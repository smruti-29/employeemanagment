package com.ems.employeemanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.employeemanagment.entity.Employee;

/**
 * EmployeeInterface
 */
public interface EmployeeInterface extends JpaRepository<Employee, Long> {

}