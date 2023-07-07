package com.calcmanagement.service.impl;

import com.calcmanagement.entity.Region;
import com.calcmanagement.exception.RegionNotFoundException;
import com.calcmanagement.mapper.EntityDTOMapper;
import com.calcmanagement.payload.RegionDTO;
import com.calcmanagement.repository.RegionRepository;
import com.calcmanagement.service.RegionService;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;
    private final EntityDTOMapper entityDTOMapper;


    public RegionServiceImpl(RegionRepository regionRepository, EntityDTOMapper entityDTOMapper) {
        this.regionRepository = regionRepository;
        this.entityDTOMapper = entityDTOMapper;
    }

    @Override
    public RegionDTO getRegionById(Long id) {
        Region region = regionRepository.findById(id)
                .orElseThrow(() -> new RegionNotFoundException("Region not found with id: " + id));
        return entityDTOMapper.convertToDTO(region);
    }

    @Override
    public RegionDTO createRegion(RegionDTO regionDTO) {
        Region region = entityDTOMapper.convertToEntity(regionDTO);
        Region savedRegion = regionRepository.save(region);
        return entityDTOMapper.convertToDTO(savedRegion);
    }

    @Override
    public RegionDTO updateRegion(Long id, RegionDTO regionDTO) {
        Region existingRegion = regionRepository.findById(id)
                .orElseThrow(() -> new RegionNotFoundException("Region not found with id: " + id));

        Region updatedRegion = entityDTOMapper.convertToEntity(regionDTO);
        updatedRegion.setId(existingRegion.getId());

        Region savedRegion = regionRepository.save(updatedRegion);
        return entityDTOMapper.convertToDTO(savedRegion);
    }

    @Override
    public void deleteRegion(Long id) {
        regionRepository.deleteById(id);
    }

}



