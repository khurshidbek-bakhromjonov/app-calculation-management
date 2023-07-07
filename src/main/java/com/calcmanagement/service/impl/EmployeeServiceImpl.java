package com.calcmanagement.service.impl;

import com.calcmanagement.entity.Employee;
import com.calcmanagement.exception.EmployeeNotFoundException;
import com.calcmanagement.mapper.EntityDTOMapper;
import com.calcmanagement.payload.EmployeeDTO;
import com.calcmanagement.repository.EmployeeRepository;
import com.calcmanagement.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EntityDTOMapper entityDTOMapper;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EntityDTOMapper entityDTOMapper) {
        this.employeeRepository = employeeRepository;
        this.entityDTOMapper = entityDTOMapper;
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
        return entityDTOMapper.convertToDTO(employee);
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = entityDTOMapper.convertToEntity(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return entityDTOMapper.convertToDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));

        Employee updatedEmployee = entityDTOMapper.convertToEntity(employeeDTO);
        updatedEmployee.setId(existingEmployee.getId());

        Employee savedEmployee = employeeRepository.save(updatedEmployee);
        return entityDTOMapper.convertToDTO(savedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

}