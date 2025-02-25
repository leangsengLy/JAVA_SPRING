package net.javaguide.ems.service.impl;

import lombok.AllArgsConstructor;
import net.javaguide.ems.dto.EmployeeDto;
import net.javaguide.ems.entity.Employee;
import net.javaguide.ems.exception.ResourseNotFoundException;
import net.javaguide.ems.mapper.EmployeeMapper;
import net.javaguide.ems.repository.EmployeeRepository;
import net.javaguide.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.MaptoEmployee(employeeDto);
        Employee savedEmployee =  employeeRepository.save(employee);
        return EmployeeMapper.MaptoEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee result =  employeeRepository.findById(employeeId).orElseThrow(()->new ResourseNotFoundException("Employee is not exist in our database!"));
        return EmployeeMapper.MaptoEmployeeDto(result);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> result= employeeRepository.findAll();
        return result.stream().map(emp->EmployeeMapper.MaptoEmployeeDto(emp)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {
        Employee find =  employeeRepository.findById(employeeId).orElseThrow(()->new ResourseNotFoundException("Employee is not exist in our database!"));
        find.setEmail(employeeDto.getEmail());
        find.setFirstName(employeeDto.getFirstName());
        find.setLastName(employeeDto.getLastName());
        Employee updateEmployeeObject = employeeRepository.save(find);
        return EmployeeMapper.MaptoEmployeeDto(updateEmployeeObject);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        employeeRepository.findById(employeeId).orElseThrow(()->new ResourseNotFoundException("Employee is not exist in our database!"));
        employeeRepository.deleteById(employeeId);
    }
}
