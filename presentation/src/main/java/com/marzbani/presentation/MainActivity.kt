package com.marzbani.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.marzbani.presentation.navigation.AppNavHost
import com.marzbani.presentation.theme.ImglyTaskTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * The main activity of the application. It serves as the entry point and sets up the Compose UI.
 *
 * This activity is annotated with [AndroidEntryPoint] to enable Hilt for dependency injection.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    /**
     * Called when the activity is first created. Responsible for setting up the Compose UI.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     * this Bundle contains the data it most recently supplied in [onSaveInstanceState].
     * Note: Otherwise, it is null.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            // Set the content of the activity using Compose
            setContent {
                ImglyTaskTheme {
                val navController = rememberNavController()
                // Create a Compose Surface as the top-level UI container
                AppNavHost(navController = navController)

            }
        }
    }
}
