package com.calcmanagement.controller;

import com.calcmanagement.payload.OrganisationDTO;
import com.calcmanagement.service.OrganisationService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organisations")
public class OrganisationController {
    private final OrganisationService organisationService;

    public OrganisationController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    @GetMapping("/{id}")
    public OrganisationDTO getOrganisationById(@PathVariable Long id) {
        return organisationService.getOrganisationById(id);
    }

    @PostMapping
    public OrganisationDTO createOrganisation(@RequestBody OrganisationDTO organisationDTO) {
        return organisationService.createOrganisation(organisationDTO);
    }

    @PutMapping("/{id}")
    public OrganisationDTO updateOrganisation(@PathVariable Long id, @RequestBody OrganisationDTO organisationDTO) {
        return organisationService.updateOrganisation(id, organisationDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteOrganisation(@PathVariable Long id) {
        organisationService.deleteOrganisation(id);
    }

}
