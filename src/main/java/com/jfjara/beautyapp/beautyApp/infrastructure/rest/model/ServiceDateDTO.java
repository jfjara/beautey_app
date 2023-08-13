package com.jfjara.beautyapp.beautyApp.infrastructure.rest.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class ServiceDateDTO {

    private Long id;
    private LocalDateTime dateTime;
    private List<ServiceDTO> services;
    private CustomerDTO customer;

}
