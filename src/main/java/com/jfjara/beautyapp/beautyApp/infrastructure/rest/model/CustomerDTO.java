package com.jfjara.beautyapp.beautyApp.infrastructure.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {

    private String name;
    private String firstSurname;
    private String lastSurname;
    private Long internalId;
    private String phone;
    private String mail;
}
