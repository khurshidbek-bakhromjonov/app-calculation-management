package com.calcmanagement.service;

import com.calcmanagement.payload.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO getEmployeeById(Long id);
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);
    void deleteEmployee(Long id);
}