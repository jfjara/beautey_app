package com.jfjara.beautyapp.beautyApp.application.usecase.customer;

import com.jfjara.beautyapp.beautyApp.domain.model.Customer;
import com.jfjara.beautyapp.beautyApp.domain.model.exception.CustomerNotFoundException;
import com.jfjara.beautyapp.beautyApp.domain.port.repository.CustomerRepository;
import com.jfjara.beautyapp.beautyApp.domain.port.usecase.customer.FindCustomerById;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class FindCustomerByIdUseCase implements FindCustomerById {

    private final CustomerRepository customerRepository;
    @Override
    public Customer execute(final Long internalId) throws CustomerNotFoundException {
        log.debug(":: Find Customer by Internal Id {} ::", internalId);
        return customerRepository.findById(internalId)
                .orElseThrow(() -> CustomerNotFoundException.builder().build());
    }
}
