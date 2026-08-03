package com.example.teamties.feature.employees.data.repository
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
            role = "Senior Software Engineer",
            email = "sarah.chen@teamties.com",
            phone = "+1 (555) 010-1234",
            dept = "Engineering",
            biography = "Passionate about clean code and scalable architecture. Leading the mobile infrastructure team.",
            avatarUrl = "https://i.pravatar.cc/150?u=1",
            supervisor = "David Miller"
        ),
        EmployeeDto(
            id = "2",
            firstName = "Marcus",
            lastName = "Johnson",
            role = "Product Designer",
            email = "marcus.j@teamties.com",
            phone = "+1 (555) 010-5678",
            dept = "Design",
            biography = "Crafting intuitive user experiences for over 8 years. Design systems enthusiast.",
            avatarUrl = "https://i.pravatar.cc/150?u=2",
            supervisor = "Elena Rodriguez"
        ),
        EmployeeDto(
            id = "3",
            firstName = "Elena",
            lastName = "Rodriguez",
            role = "Design Director",
            email = "elena.r@teamties.com",
            phone = "+1 (555) 010-9012",
            dept = "Design",
            biography = "Visionary leader focused on building world-class creative teams.",
            avatarUrl = "https://i.pravatar.cc/150?u=3",
            supervisor = "CEO"
        ),
        EmployeeDto(
            id = "4",
            firstName = "David",
            lastName = "Miller",
            role = "Engineering Manager",
            email = "david.m@teamties.com",
            phone = "+1 (555) 010-3456",
            dept = "Engineering",
            biography = "Helping engineers grow and delivering high-quality software products.",
            avatarUrl = "https://i.pravatar.cc/150?u=4",
            supervisor = "VP of Engineering"
        ),
        EmployeeDto(
            id = "5",
            firstName = "Aisha",
            lastName = "Khan",
            role = "HR Specialist",
            email = "aisha.k@teamties.com",
            phone = "+1 (555) 010-7890",
            dept = "Human Resources",
            biography = "Dedicated to creating an inclusive and supportive workplace culture.",
            avatarUrl = "https://i.pravatar.cc/150?u=5",
            supervisor = "Robert Wilson"
        ),
        EmployeeDto(
            id = "6",
            firstName = "James",
            lastName = "Wilson",
            role = "Marketing Lead",
            email = "james.w@teamties.com",
            phone = "+1 (555) 010-2345",
            dept = "Marketing",
            biography = "Data-driven marketer with a focus on brand growth and engagement.",
            avatarUrl = "https://i.pravatar.cc/150?u=6",
            supervisor = "Linda Garcia"
        ),
        EmployeeDto(
            id = "7",
            firstName = "Sophia",
            lastName = "Lee",
            role = "Data Scientist",
            email = "sophia.l@teamties.com",
            phone = "+1 (555) 010-6789",
            dept = "Data & Analytics",
            biography = "Extracting insights from complex data to drive business decisions.",
            avatarUrl = "https://i.pravatar.cc/150?u=7",
            supervisor = "David Miller"
        ),
        EmployeeDto(
            id = "8",
            firstName = "Thomas",
            lastName = "Brown",
            role = "DevOps Engineer",
            email = "thomas.b@teamties.com",
            phone = "+1 (555) 010-0123",
            dept = "Engineering",
            biography = "Automation expert ensuring seamless deployments and system reliability.",
            avatarUrl = "https://i.pravatar.cc/150?u=8",
            supervisor = "David Miller"
        )
    ))
    override fun getEmployees(): Flow<List<Employee>> {
        return _employees.map { dtoBatch ->
            dtoBatch.map { it.toDomain() }
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
