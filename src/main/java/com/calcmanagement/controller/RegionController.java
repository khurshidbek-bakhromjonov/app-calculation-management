package com.calcmanagement.controller;

import com.calcmanagement.payload.RegionDTO;
import com.calcmanagement.service.RegionService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/regions")
public class RegionController {
    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("/{id}")
    public RegionDTO getRegionById(@PathVariable Long id) {
        return regionService.getRegionById(id);
    }

    @PostMapping
    public RegionDTO createRegion(@RequestBody RegionDTO regionDTO) {
        return regionService.createRegion(regionDTO);
    }

    @PutMapping("/{id}")
    public RegionDTO updateRegion(@PathVariable Long id, @RequestBody RegionDTO regionDTO) {
        return regionService.updateRegion(id, regionDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRegion(@PathVariable Long id) {
        regionService.deleteRegion(id);
    }

    // Add other endpoints as needed
}
