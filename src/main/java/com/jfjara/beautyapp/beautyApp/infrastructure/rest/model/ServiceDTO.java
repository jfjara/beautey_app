package com.jfjara.beautyapp.beautyApp.infrastructure.rest.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class ServiceDTO {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer durationInMinutes;
    private boolean active;
}
