package com.jfjara.beautyapp.beautyApp.domain.model;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class Customer {
    Long id;
    String name;
    String firstSurname;
    String lastSurname;
    Long internalId;
    String phone;
    String mail;

}
