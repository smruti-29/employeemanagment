package com.ems.employeemanagment.mapper;

import com.ems.employeemanagment.dto.EmployeeDto;
import com.ems.employeemanagment.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail());
    }

    public static Employee mapTomEmployee(EmployeeDto employeeDto) {
        return new Employee(employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail());
    }
}
