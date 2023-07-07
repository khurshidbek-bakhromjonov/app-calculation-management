package com.calcmanagement.service;

import com.calcmanagement.payload.OrganisationDTO;

public interface OrganisationService {
    OrganisationDTO getOrganisationById(Long id);
    OrganisationDTO createOrganisation(OrganisationDTO organisationDTO);
    OrganisationDTO updateOrganisation(Long id, OrganisationDTO organisationDTO);
    void deleteOrganisation(Long id);
}