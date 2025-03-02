package employee.employee_api.Service.Interface;


import employee.employee_api.Dto.Employee.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> GetAllEmployee();
    EmployeeDto Create(EmployeeDto employee);
    EmployeeDto GetEmployeeById(Long employeeId);
    EmployeeDto Update(Long employeeId,EmployeeDto employee);
    void DeleteEmployee(Long employeeId);
}
