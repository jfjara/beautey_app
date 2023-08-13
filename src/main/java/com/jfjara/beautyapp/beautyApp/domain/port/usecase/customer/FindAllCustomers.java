package com.jfjara.beautyapp.beautyApp.domain.port.usecase.customer;

import com.jfjara.beautyapp.beautyApp.domain.model.Customer;
import com.jfjara.beautyapp.beautyApp.domain.model.exception.CustomerNotFoundException;

import java.util.List;

public interface FindAllCustomers {

    List<Customer> execute() throws CustomerNotFoundException;
}
