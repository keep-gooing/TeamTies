package com.example.teamties.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.teamties.feature.auth.presentation.ui.LoginScreen
import com.example.teamties.feature.chat.presentation.ui.ChannelListScreen
import com.example.teamties.feature.chat.presentation.ui.ChatScreen
import com.example.teamties.feature.employees.presentation.ui.DirectoryScreen
import com.example.teamties.feature.employees.presentation.ui.EmployeeProfileScreen
@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.Login.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(Screen.Login.route) {
            LoginScreen(
                viewModel = hiltViewModel(),
                onLoginSuccess = {
                    navController.navigate(Screen.Directory.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                }
            )
        }
        composable(Screen.Directory.route) {
            DirectoryScreen(
                onEmployeeClick = { employeeId ->
                    navController.navigate(Screen.Profile.createRoute(employeeId))
                },
                onChatClick = {
                    navController.navigate(Screen.Channels.route)
                }
            )
        }
        composable(Screen.Profile.route) {
            EmployeeProfileScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
        composable(Screen.Channels.route) {
            ChannelListScreen(
                viewModel = hiltViewModel(),
                onChannelClick = { channelId ->
                    navController.navigate(Screen.Chat.createRoute(channelId))
                }
            )
        }
        composable(Screen.Chat.route) { backStackEntry ->
            val channelId = backStackEntry.arguments?.getString("channelId") ?: return@composable
            ChatScreen(
                viewModel = hiltViewModel(),
                channelId = channelId,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
