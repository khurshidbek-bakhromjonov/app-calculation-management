package com.calcmanagement.service.impl;

import com.calcmanagement.entity.Calculation;
import com.calcmanagement.exception.CalculationNotFoundException;
import com.calcmanagement.mapper.EntityDTOMapper;
import com.calcmanagement.payload.CalculationDTO;
import com.calcmanagement.repository.CalculationRepository;
import com.calcmanagement.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CalculationServiceImpl implements CalculationService {

    private final CalculationRepository calculationRepository;
    private final EntityDTOMapper entityDTOMapper;

    @Autowired
    public CalculationServiceImpl(CalculationRepository calculationRepository, EntityDTOMapper entityDTOMapper) {
        this.calculationRepository = calculationRepository;
        this.entityDTOMapper = entityDTOMapper;
    }

    @Override
    public CalculationDTO getCalculationById(Long id) {
        Calculation calculation = calculationRepository.findById(id)
                .orElseThrow(() -> new CalculationNotFoundException("Calculation not found with id: " + id));
        return entityDTOMapper.convertToDTO(calculation);
    }

    @Override
    public CalculationDTO createCalculation(CalculationDTO calculationDTO) {
        Calculation calculation = entityDTOMapper.convertToEntity(calculationDTO);
        Calculation savedCalculation = calculationRepository.save(calculation);
        return entityDTOMapper.convertToDTO(savedCalculation);
    }

    @Override
    public CalculationDTO updateCalculation(Long id, CalculationDTO calculationDTO) {
        Calculation existingCalculation = calculationRepository.findById(id)
                .orElseThrow(() -> new CalculationNotFoundException("Calculation not found with id: " + id));

        existingCalculation.setAmount(calculationDTO.getAmount());
        existingCalculation.setRate(calculationDTO.getRate());
        existingCalculation.setDate(calculationDTO.getDate());
        existingCalculation.setCalculationType(calculationDTO.getCalculationType());

        Calculation updatedCalculation = calculationRepository.save(existingCalculation);
        return entityDTOMapper.convertToDTO(updatedCalculation);
    }

    @Override
    public void deleteCalculation(Long id) {
        if (!calculationRepository.existsById(id)) {
            throw new CalculationNotFoundException("Calculation not found with id: " + id);
        }
        calculationRepository.deleteById(id);
    }
}
