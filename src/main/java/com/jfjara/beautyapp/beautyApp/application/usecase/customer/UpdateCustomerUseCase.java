package com.jfjara.beautyapp.beautyApp.application.usecase.customer;

import com.jfjara.beautyapp.beautyApp.domain.model.Customer;
import com.jfjara.beautyapp.beautyApp.domain.model.exception.CustomerNotFoundException;
import com.jfjara.beautyapp.beautyApp.domain.port.repository.CustomerRepository;
import com.jfjara.beautyapp.beautyApp.domain.port.usecase.customer.UpdateCustomer;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateCustomerUseCase implements UpdateCustomer {

    private final CustomerRepository customerRepository;


    @Override
    public Customer execute(final Customer customer) throws CustomerNotFoundException {
        return customerRepository.update(customer)
                .orElseThrow(() -> CustomerNotFoundException.builder().message("No customer found").build());
    }
}
