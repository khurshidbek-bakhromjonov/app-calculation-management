package com.calcmanagement.service.impl;

import com.calcmanagement.entity.Organisation;
import com.calcmanagement.exception.OrganisationNotFoundException;
import com.calcmanagement.mapper.EntityDTOMapper;
import com.calcmanagement.payload.OrganisationDTO;
import com.calcmanagement.repository.OrganisationRepository;
import com.calcmanagement.service.OrganisationService;
import org.springframework.stereotype.Service;

@Service
public class OrganisationServiceImpl implements OrganisationService {
    private final OrganisationRepository organisationRepository;
    private final EntityDTOMapper entityDTOMapper;

    public OrganisationServiceImpl(OrganisationRepository organisationRepository, EntityDTOMapper entityDTOMapper) {
        this.organisationRepository = organisationRepository;
        this.entityDTOMapper = entityDTOMapper;
    }

    @Override
    public OrganisationDTO getOrganisationById(Long id) {
        Organisation organisation = organisationRepository.findById(id)
                .orElseThrow(() -> new OrganisationNotFoundException("Organisation not found with id: " + id));
        return entityDTOMapper.convertToDTO(organisation);
    }

    @Override
    public OrganisationDTO createOrganisation(OrganisationDTO organisationDTO) {
        Organisation organisation = entityDTOMapper.convertToEntity(organisationDTO);
        Organisation savedOrganisation = organisationRepository.save(organisation);
        return entityDTOMapper.convertToDTO(savedOrganisation);
    }

    @Override
    public OrganisationDTO updateOrganisation(Long id, OrganisationDTO organisationDTO) {
        Organisation existingOrganisation = organisationRepository.findById(id)
                .orElseThrow(() -> new OrganisationNotFoundException("Organisation not found with id: " + id));

        Organisation updatedOrganisation = entityDTOMapper.convertToEntity(organisationDTO);
        updatedOrganisation.setId(existingOrganisation.getId());

        Organisation savedOrganisation = organisationRepository.save(updatedOrganisation);
        return entityDTOMapper.convertToDTO(savedOrganisation);
    }

    @Override
    public void deleteOrganisation(Long id) {
        organisationRepository.deleteById(id);
    }

}