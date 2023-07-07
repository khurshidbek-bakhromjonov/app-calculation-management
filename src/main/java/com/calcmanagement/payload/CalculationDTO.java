package com.calcmanagement.payload;

import com.calcmanagement.entity.CalculationType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CalculationDTO {
    private Long id;
    private Long employeeId;
    private Double amount;
    private Double rate;
    private LocalDate date;
    private Long organisationId;
    private CalculationType calculationType;
}