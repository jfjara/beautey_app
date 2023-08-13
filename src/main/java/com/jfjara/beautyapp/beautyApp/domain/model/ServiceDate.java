package com.jfjara.beautyapp.beautyApp.domain.model;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Value
public class ServiceDate {

    Long id;
    LocalDateTime dateTime;
    List<Service> services;
    Customer customer;

    public BigDecimal getTotalAmount() {
        return services.stream().map(Service::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public LocalDateTime getEndOfServiceDate() {
        var totalMinutes = services.stream().map(Service::getDurationInMinutes).reduce(0, Integer::sum);
        return dateTime.plusMinutes(totalMinutes);
    }

}
