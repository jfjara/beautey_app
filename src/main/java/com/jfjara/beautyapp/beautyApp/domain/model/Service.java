package com.jfjara.beautyapp.beautyApp.domain.model;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Builder
@Value
public class Service {

    Long id;
    String name;
    String description;
    BigDecimal price;
    Integer durationInMinutes;
    boolean active;
}
