package com.example.teamties.feature.employees.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teamties.core.model.Employee
import com.example.teamties.core.ui.theme.TeamTiesTheme

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
