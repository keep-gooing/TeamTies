package com.example.teamties.feature.employees.data.repository
import com.example.teamties.core.model.AppPermission
import com.example.teamties.core.model.Employee
import com.example.teamties.feature.employees.data.mapper.toDomain
import com.example.teamties.feature.employees.data.model.EmployeeDto
import com.example.teamties.feature.employees.domain.repository.EmployeeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton
@Singleton
class FakeEmployeeRepositoryImpl @Inject constructor() : EmployeeRepository {
    private val _employees = MutableStateFlow(listOf(
        EmployeeDto(
            id = "1",
            firstName = "Sarah",
            lastName = "Chen",
            position = "Senior Software Engineer",
            email = "sarah.chen@teamties.com",
            phone = "+1 (555) 010-1234",
            dept = "Engineering",
            biography = "Passionate about clean code and scalable architecture. Leading the mobile infrastructure team.",
            permissions = setOf(AppPermission.ACCESS_ADMIN_PANEL),
            avatarUrl = "https://i.pravatar.cc/150?u=1",
            supervisor = "David Miller"
        ),
        EmployeeDto(
            id = "2",
            firstName = "Marcus",
            lastName = "Johnson",
            position = "Product Designer",
            email = "marcus.j@teamties.com",
            phone = "+1 (555) 010-5678",
            dept = "Design",
            biography = "Crafting intuitive user experiences for over 8 years. Design systems enthusiast.",
            permissions = setOf(AppPermission.ACCESS_ADMIN_PANEL),
            avatarUrl = "https://i.pravatar.cc/150?u=2",
            supervisor = "Elena Rodriguez"
        ),
        EmployeeDto(
            id = "3",
            firstName = "Elena",
            lastName = "Rodriguez",
            position = "Design Director",
            email = "elena.r@teamties.com",
            phone = "+1 (555) 010-9012",
            dept = "Design",
            biography = "Visionary leader focused on building world-class creative teams.",
            permissions = setOf(AppPermission.MANAGE_EMPLOYEES, AppPermission.MANAGE_DEPARTMENTS, AppPermission.ACCESS_ADMIN_PANEL),
            avatarUrl = "https://i.pravatar.cc/150?u=3",
            supervisor = "CEO"
        ),
        EmployeeDto(
            id = "4",
            firstName = "David",
            lastName = "Miller",
            position = "Engineering Manager",
            email = "david.m@teamties.com",
            phone = "+1 (555) 010-3456",
            dept = "Engineering",
            biography = "Helping engineers grow and delivering high-quality software products.",
            permissions = setOf(AppPermission.MANAGE_EMPLOYEES, AppPermission.MANAGE_DEPARTMENTS, AppPermission.ACCESS_ADMIN_PANEL),
            avatarUrl = "https://i.pravatar.cc/150?u=4",
            supervisor = "VP of Engineering"
        ),
        EmployeeDto(
            id = "5",
            firstName = "Aisha",
            lastName = "Khan",
            position = "HR Specialist",
            email = "aisha.k@teamties.com",
            phone = "+1 (555) 010-7890",
            dept = "Human Resources",
            biography = "Dedicated to creating an inclusive and supportive workplace culture.",
            permissions = setOf(AppPermission.MANAGE_EMPLOYEES),
            avatarUrl = "https://i.pravatar.cc/150?u=5",
            supervisor = "Robert Wilson"
        ),
        EmployeeDto(
            id = "6",
            firstName = "James",
            lastName = "Wilson",
            position = "Marketing Lead",
            email = "james.w@teamties.com",
            phone = "+1 (555) 010-2345",
            dept = "Marketing",
            biography = "Data-driven marketer with a focus on brand growth and engagement.",
            permissions = setOf(AppPermission.ACCESS_ADMIN_PANEL),
            avatarUrl = "https://i.pravatar.cc/150?u=6",
            supervisor = "Linda Garcia"
        ),
        EmployeeDto(
            id = "7",
            firstName = "Sophia",
            lastName = "Lee",
            position = "Data Scientist",
            email = "sophia.l@teamties.com",
            phone = "+1 (555) 010-6789",
            dept = "Data & Analytics",
            biography = "Extracting insights from complex data to drive business decisions.",
            permissions = setOf(AppPermission.ACCESS_ADMIN_PANEL),
            avatarUrl = "https://i.pravatar.cc/150?u=7",
            supervisor = "David Miller"
        ),
        EmployeeDto(
            id = "8",
            firstName = "Thomas",
            lastName = "Brown",
            position = "DevOps Engineer",
            email = "thomas.b@teamties.com",
            phone = "+1 (555) 010-0123",
            dept = "Engineering",
            biography = "Automation expert ensuring seamless deployments and system reliability.",
            permissions = setOf(AppPermission.ACCESS_ADMIN_PANEL),
            avatarUrl = "https://i.pravatar.cc/150?u=8",
            supervisor = "David Miller"
        )
    ))
    override fun getEmployees(): Flow<List<Employee>> {
        return _employees.map { dtoBatch ->
            dtoBatch.map { it.toDomain() }
        }
    }

    override fun searchEmployees(query: String): Flow<List<Employee>> {
        return _employees.map { employees ->
            val filtered = if (query.isBlank()) {
                employees
            } else {
                employees.filter { employee ->
                    employee.firstName.contains(query, ignoreCase = true) ||
                            employee.lastName.contains(query, ignoreCase = true) ||
                            employee.position.contains(query, ignoreCase = true) ||
                            employee.dept.contains(query, ignoreCase = true)
                }
            }
            filtered.map { it.toDomain() }
        }
    }
    override suspend fun getEmployeeById(id: String): Employee? {
        return _employees.value.find { it.id == id }?.toDomain()
    }
    override suspend fun addEmployee(employee: Employee) {
    }
    override suspend fun deleteEmployee(id: String) {
        _employees.value = _employees.value.filterNot { it.id == id }
    }
}
