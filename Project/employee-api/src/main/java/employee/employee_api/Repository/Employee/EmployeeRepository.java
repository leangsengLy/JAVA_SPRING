package employee.employee_api.Repository.Employee;

import employee.employee_api.Entity.Employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
