package com.ems.employeemanagment.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ems.employeemanagment.dto.EmployeeDto;
import com.ems.employeemanagment.entity.Employee;
import com.ems.employeemanagment.exception.ResourceNotFoundException;
import com.ems.employeemanagment.mapper.EmployeeMapper;
import com.ems.employeemanagment.repository.EmployeeInterface;
import com.ems.employeemanagment.service.EmployeeService;

import lombok.AllArgsConstructor;

/**
 * EmployeeServiceImpl
 */
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeInterface employeeInterface;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapTomEmployee(employeeDto);

        Employee savedEmployee = employeeInterface.save(employee);

        return EmployeeMapper.mapEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        Employee employee = employeeInterface.findById(employeeId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Exception is not existiswith given id : " + employeeId));
        return EmployeeMapper.mapEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees = employeeInterface.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    // update servvice Method
    @Override
    public EmployeeDto updaEmployee(Long employeeId, EmployeeDto updateEmployee) {
        Employee employee = employeeInterface.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id: " + employeeId));

        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setEmail(updateEmployee.getEmail());

        Employee updateEmployeeObj = employeeInterface.save(employee);
        return EmployeeMapper.mapEmployeeDto(updateEmployeeObj);

    }

    // delete service method
    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeInterface.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id: " + employeeId));

        employeeInterface.deleteById(employeeId);
    }
}