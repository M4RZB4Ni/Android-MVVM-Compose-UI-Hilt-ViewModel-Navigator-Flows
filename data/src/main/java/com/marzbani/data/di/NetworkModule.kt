package com.marzbani.data.di

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.google.gson.Gson
import com.marzbani.data.mapper.MapperFactoryImpl
import com.marzbani.data.repository.NodesRepositoryImpl
import com.marzbani.data.source.NodesService
import com.marzbani.domain.repository.NodesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

//Url for the Retrofit
const val BASE_URL = "https://ubique.img.ly/frontend-tha/"

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    // Provides Retrofit instance
    @Provides
    @Singleton
    fun providesRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        rxJava2CallAdapterFactory: RxJava2CallAdapterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .client(okHttpClient)
            .build()
    }

    // Provides OkHttpClient instance
    @Provides
    @Singleton
    fun providesOkHttpClient(
        @ApplicationContext context: Context
    ): OkHttpClient {
        // Configure OkHttpClient with caching and logging
        val cacheSize = (5 * 1024 * 1024).toLong()
        val mCache = Cache(context.cacheDir, cacheSize)
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .cache(mCache)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addNetworkInterceptor(interceptor)
            .addInterceptor { chain ->
                var request = chain.request()
                request = request.newBuilder()
                    .header("Cache-Control", "public, max-age=" + 5).build()
                chain.proceed(request)
            }
        return client.build()
    }

    // Provides Gson instance
    @Provides
    @Singleton
    fun providesGson(): Gson {
        return Gson()
    }

    // Provides GsonConverterFactory instance
    @Provides
    @Singleton
    fun providesGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    // Provides RxJava2CallAdapterFactory instance
    @Provides
    @Singleton
    fun providesRxJavaCallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    // Provides network availability status
    @Provides
    @Singleton
    fun provideIsNetworkAvailable(@ApplicationContext context: Context): Boolean {
        // Check if the device has an active network connection
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val nw = connectivityManager.activeNetwork ?: return false
        val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
        return when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
            else -> false
        }
    }

    // Provides NodesService instance
    @Singleton
    @Provides
    fun provideNodesService(retrofit: Retrofit): NodesService {
        return retrofit.create(NodesService::class.java)
    }

    // Provides MapperFactory instance
    @Singleton
    @Provides
    fun provideMapperFactory(): MapperFactory {
        return MapperFactoryImpl()
    }

    // Provides NodesRepository instance
    @Singleton
    @Provides
    fun provideNodesRepository(
        retrofitService: NodesService,
        mapperFactory: MapperFactory
    ): NodesRepository {
        return NodesRepositoryImpl(
            retrofitService,
            mapperFactory.provideTreeNodeEntityMapper(),
            mapperFactory.provideDetailsEntityMapper()
        )
    }
}
