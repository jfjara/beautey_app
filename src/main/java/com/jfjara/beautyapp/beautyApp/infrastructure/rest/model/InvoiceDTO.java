package com.jfjara.beautyapp.beautyApp.infrastructure.rest.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Getter
public class InvoiceDTO {
    private Long id;
    private String name;
    private BigDecimal amount;
    private LocalDate date;
}
