package net.javaguide.ems.controller;

import lombok.AllArgsConstructor;
import net.javaguide.ems.dto.EmployeeDto;
import net.javaguide.ems.entity.Employee;
import net.javaguide.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto saveEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    };
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
          EmployeeDto result =   employeeService.getEmployeeById(employeeId);
          return ResponseEntity.ok(result);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> result = employeeService.getAllEmployees();
        return ResponseEntity.ok(result);
    }
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto updateEmployeeDto) {
        EmployeeDto result = employeeService.updateEmployee(employeeId,updateEmployeeDto);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Delete employee successfully");
    }

}


