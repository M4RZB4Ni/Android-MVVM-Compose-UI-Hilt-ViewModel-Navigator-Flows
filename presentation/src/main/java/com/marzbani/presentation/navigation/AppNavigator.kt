// AppNavHost.kt
package com.marzbani.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.marzbani.presentation.details.DetailsScreen
import com.marzbani.presentation.details.DetailsViewModel
import com.marzbani.presentation.nodes.NodesScreen
import com.marzbani.presentation.nodes.NodesViewModel

/**
 * Composable function defining the navigation host for the app.
 *
 * @param navController NavHostController for handling the route.
 * @param startDestination Starting destination for the navigation host.
 */
@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String = NavigationItem.NODES.route,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // Composable for the NODES screen
        composable(NavigationItem.NODES.route) {
            val viewModel = hiltViewModel<NodesViewModel>()
            NodesScreen(viewModel, navController)
        }

        // Composable for the DETAILS screen with a dynamic nodeID argument
        composable(
            route = "${NavigationItem.DETAILS.route}/{nodeID}",
            arguments = listOf(navArgument("nodeID") { type = NavType.StringType })
        ) { backStackEntry ->
            val nodeId = backStackEntry.arguments?.getString("nodeID") ?: ""
            val viewModel = hiltViewModel<DetailsViewModel>()
            DetailsScreen(viewModel, nodeId, navController)
        }
    }
}
