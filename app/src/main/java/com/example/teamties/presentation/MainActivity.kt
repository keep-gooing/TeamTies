package com.example.teamties.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.teamties.domain.model.Employee
import com.example.teamties.presentation.ui.theme.TeamTiesTheme
import com.example.teamties.presentation.viewmodel.EmployeeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TeamTiesTheme {
                val viewModel: EmployeeViewModel = viewModel()
                val employees by viewModel.employees.collectAsState()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EmployeeList(
                        employees = employees,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun EmployeeList(employees: List<Employee>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(employees) { employee ->
            EmployeeItem(employee)
            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        }
    }
}

@Composable
fun EmployeeItem(employee: Employee) {
    Column {
        Text(text = employee.name, style = MaterialTheme.typography.titleLarge)
        Text(text = "${employee.position} - ${employee.department}", style = MaterialTheme.typography.bodyMedium)
        Text(text = employee.email, style = MaterialTheme.typography.bodySmall)
    }
}

@Preview(showBackground = true)
@Composable
fun EmployeeListPreview() {
    TeamTiesTheme {
        EmployeeList(
            employees = listOf(
                Employee("1", "John Doe", "Developer", "john@example.com", "IT"),
                Employee("2", "Jane Smith", "Designer", "jane@example.com", "Creative")
            )
        )
    }
}
