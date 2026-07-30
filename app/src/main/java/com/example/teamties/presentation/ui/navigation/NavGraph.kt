package com.example.teamties.presentation.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.teamties.feature.auth.presentation.ui.LoginScreen
import com.example.teamties.feature.auth.presentation.viewmodel.AuthViewModel
import com.example.teamties.feature.employees.presentation.ui.EmployeeList
import com.example.teamties.feature.employees.presentation.viewmodel.EmployeeViewModel

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
            val authViewModel: AuthViewModel = hiltViewModel()
            LoginScreen(
                viewModel = authViewModel,
                onLoginSuccess = {
                    navController.navigate(Screen.Directory.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                }
            )
        }
        composable(Screen.Directory.route) {
            val employeeViewModel: EmployeeViewModel = hiltViewModel()
            val employees by employeeViewModel.employees.collectAsState()

            Scaffold { innerPadding ->
                EmployeeList(
                    employees = employees,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}
