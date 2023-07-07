package com.calcmanagement.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "calculations")
@Data
@NoArgsConstructor
public class Calculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column
    private Double amount;

    @Column
    private Double rate;

    @Column
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "organisation_id")
    private Organisation organisation;

    @Enumerated(EnumType.STRING)
    private CalculationType calculationType;
}
