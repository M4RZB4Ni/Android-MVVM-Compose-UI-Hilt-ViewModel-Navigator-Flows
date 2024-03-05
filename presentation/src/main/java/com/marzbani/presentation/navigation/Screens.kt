package com.marzbani.presentation.navigation

/**
 * Enumeration defining available screens in the app.
 */
enum class Screens {
    NODES,       // Screen for displaying nodes
    DETAILS,     // Screen for displaying details
}

/**
 * Sealed class representing the navigation items with their associated route.
 */
sealed class NavigationItem(val route: String) {
    /**
     * Data object for the NODES screen.
     */
    data object NODES : NavigationItem(Screens.NODES.name)

    /**
     * Data object for the DETAILS screen.
     */
    data object DETAILS : NavigationItem(Screens.DETAILS.name)

}
