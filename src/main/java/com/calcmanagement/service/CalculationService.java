package com.calcmanagement.service;

import com.calcmanagement.payload.CalculationDTO;

public interface CalculationService {
    CalculationDTO getCalculationById(Long id);
    CalculationDTO createCalculation(CalculationDTO calculationDTO);
    CalculationDTO updateCalculation(Long id, CalculationDTO calculationDTO);
    void deleteCalculation(Long id);
}