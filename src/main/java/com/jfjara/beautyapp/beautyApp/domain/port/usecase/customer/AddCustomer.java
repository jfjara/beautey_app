package com.jfjara.beautyapp.beautyApp.domain.port.usecase.customer;

import com.jfjara.beautyapp.beautyApp.domain.model.Customer;
import com.jfjara.beautyapp.beautyApp.domain.model.exception.EmptyCustomerException;

public interface AddCustomer {

    void execute(final Customer customer) throws EmptyCustomerException;
}
