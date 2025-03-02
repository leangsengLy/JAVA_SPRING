package employee.employee_api.Controller.Employee;

import employee.employee_api.Dto.Employee.EmployeeDto;
import employee.employee_api.Service.Interface.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("list")
    public ResponseEntity<List<EmployeeDto>> getAll() {
        List<EmployeeDto> list = employeeService.GetAllEmployee();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("getby/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id) {
        EmployeeDto employee = employeeService.GetEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employee) {
        EmployeeDto create = employeeService.Create(employee);
        return new ResponseEntity<>(create, HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id,@RequestBody EmployeeDto employee) {
        EmployeeDto update = employeeService.Update(id, employee);
        return ResponseEntity.ok(update);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> DeleteEmployee(@PathVariable("id") Long id) {
        employeeService.DeleteEmployee(id);
        return ResponseEntity.ok("Employee Deleted");
    }

}
