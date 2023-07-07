package com.calcmanagement.payload;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String pinfl;
    private LocalDate hireDate;
    private Long organisationId;
}