package com.jfjara.beautyapp.beautyApp.domain.port.usecase.customer;

public interface GenerateCustomerQR {

    byte[] execute(final Long id);
}
