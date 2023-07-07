package com.calcmanagement.mapper;

import com.calcmanagement.entity.Calculation;
import com.calcmanagement.entity.Employee;
import com.calcmanagement.entity.Organisation;
import com.calcmanagement.entity.Region;
import com.calcmanagement.payload.CalculationDTO;
import com.calcmanagement.payload.EmployeeDTO;
import com.calcmanagement.payload.OrganisationDTO;
import com.calcmanagement.payload.RegionDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDTOMapper {

    private final ModelMapper modelMapper;

    public EntityDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CalculationDTO convertToDTO(Calculation calculation) {
        return modelMapper.map(calculation, CalculationDTO.class);
    }

    public Calculation convertToEntity(CalculationDTO calculationDTO) {
        return modelMapper.map(calculationDTO, Calculation.class);
    }

    public EmployeeDTO convertToDTO(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    public Employee convertToEntity(EmployeeDTO employeeDTO) {
        return modelMapper.map(employeeDTO, Employee.class);
    }

    public OrganisationDTO convertToDTO(Organisation organisation) {
        return modelMapper.map(organisation, OrganisationDTO.class);
    }

    public Organisation convertToEntity(OrganisationDTO organisationDTO) {
        return modelMapper.map(organisationDTO, Organisation.class);
    }

    public RegionDTO convertToDTO(Region region) {
        return modelMapper.map(region, RegionDTO.class);
    }

    public Region convertToEntity(RegionDTO regionDTO) {
        return modelMapper.map(regionDTO, Region.class);
    }
}

