package employee.employee_api.Service.Implement.Employee;

import employee.employee_api.Dto.Employee.EmployeeDto;
import employee.employee_api.Entity.Employee.Employee;
import employee.employee_api.Exception.Employee.ResourceNotFound;
import employee.employee_api.Mapper.Employee.EmployeeMapper;
import employee.employee_api.Repository.Employee.EmployeeRepository;
import employee.employee_api.Service.Interface.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class EmployeeImplement implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Override
    public List<EmployeeDto> GetAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employee->EmployeeMapper.MapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto Create(EmployeeDto employee) {
        Employee emp = EmployeeMapper.MapToEmployee(employee);
        System.out.println(emp);
        Employee resultSave =  employeeRepository.save(emp);
        System.out.println(resultSave);
        return EmployeeMapper.MapToEmployeeDto(resultSave);
    }

    @Override
    public EmployeeDto GetEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if(employee == null) {
            return null;
        }
        return EmployeeMapper.MapToEmployeeDto(employee);
    }

    @Override
    public EmployeeDto Update(Long employeeId, EmployeeDto employee) {
        Employee findEmployee = employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFound("The Id of employee not found!"));
        findEmployee.setFirstName(employee.getFirstName());
        findEmployee.setLastName(employee.getLastName());
        findEmployee.setEmail(employee.getEmail());
        findEmployee.setPhone(employee.getPhone());
        findEmployee.setSalary(employee.getSalary());
        findEmployee.setAddress(employee.getAddress());
        findEmployee.setFacebookName(employee.getFacebookName());
        Employee updateEmployee = employeeRepository.save(findEmployee);
        return EmployeeMapper.MapToEmployeeDto(updateEmployee);
    }

    @Override
    public void DeleteEmployee(Long employeeId) {
        employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFound("The Id of employee not found!"));
        employeeRepository.deleteById(employeeId);
    }
}
