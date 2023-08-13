package com.jfjara.beautyapp.beautyApp.domain.port.usecase.customer;

import com.jfjara.beautyapp.beautyApp.domain.model.Customer;
import com.jfjara.beautyapp.beautyApp.domain.model.exception.CustomerNotFoundException;

public interface UpdateCustomer {

    Customer execute(final Customer customer) throws CustomerNotFoundException;
}
