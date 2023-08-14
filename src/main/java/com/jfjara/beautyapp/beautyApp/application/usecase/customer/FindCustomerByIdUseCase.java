package com.jfjara.beautyapp.beautyApp.application.usecase.customer;

import com.jfjara.beautyapp.beautyApp.domain.model.Customer;
import com.jfjara.beautyapp.beautyApp.domain.model.exception.CustomerNotFoundException;
import com.jfjara.beautyapp.beautyApp.domain.port.repository.CustomerRepository;
import com.jfjara.beautyapp.beautyApp.domain.port.usecase.customer.FindCustomerById;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindCustomerByIdUseCase implements FindCustomerById {

    private final CustomerRepository customerRepository;
    @Override
    public Customer execute(final Long customerId) throws CustomerNotFoundException {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> CustomerNotFoundException.builder().build());
    }
}
