package com.jfjara.beautyapp.beautyApp.domain.model;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Value
public class Invoice {
    Long id;
    String name;
    BigDecimal amount;
    LocalDate date;
}
