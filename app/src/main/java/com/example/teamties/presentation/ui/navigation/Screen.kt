package com.example.teamties.presentation.ui.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Directory : Screen("directory")
    object Profile : Screen("profile/{employeeId}") {
        fun createRoute(employeeId: String) = "profile/$employeeId"
    }
    object Channels : Screen("channels")
    object Chat : Screen("chat/{channelId}") {
        fun createRoute(channelId: String) = "chat/$channelId"
    }
}
