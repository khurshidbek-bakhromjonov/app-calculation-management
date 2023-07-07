package com.calcmanagement.controller;

import com.calcmanagement.payload.CalculationDTO;
import com.calcmanagement.service.CalculationService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculations")
public class CalculationController {
    private final CalculationService calculationService;

    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping("/{id}")
    public CalculationDTO getCalculationById(@PathVariable Long id) {
        return calculationService.getCalculationById(id);
    }

    @PostMapping
    public CalculationDTO createCalculation(@RequestBody CalculationDTO calculationDTO) {
        return calculationService.createCalculation(calculationDTO);
    }

    @PutMapping("/{id}")
    public CalculationDTO updateCalculation(@PathVariable Long id, @RequestBody CalculationDTO calculationDTO) {
        return calculationService.updateCalculation(id, calculationDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCalculation(@PathVariable Long id) {
        calculationService.deleteCalculation(id);
    }

}
