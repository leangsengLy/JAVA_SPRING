package employee.employee_api.Mapper.Employee;

import employee.employee_api.Dto.Employee.EmployeeDto;
import employee.employee_api.Entity.Employee.Employee;

public class EmployeeMapper {
    public static Employee MapToEmployee(EmployeeDto employee) {
        return new Employee(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getPhone(),
                employee.getAddress(),
                employee.getEmail(),
                employee.getSalary(),
                employee.getFacebookName()
        );
    }

    public static EmployeeDto MapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getPhone(),
                employee.getAddress(),
                employee.getEmail(),
                employee.getSalary(),
                employee.getFacebookName()
        );
    }
}
