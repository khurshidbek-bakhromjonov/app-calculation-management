package com.calcmanagement.service;

import com.calcmanagement.payload.RegionDTO;

public interface RegionService {
    RegionDTO getRegionById(Long id);
    RegionDTO createRegion(RegionDTO regionDTO);
    RegionDTO updateRegion(Long id, RegionDTO regionDTO);
    void deleteRegion(Long id);
}