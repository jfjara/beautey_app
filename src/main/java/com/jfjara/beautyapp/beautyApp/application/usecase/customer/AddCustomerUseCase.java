package com.jfjara.beautyapp.beautyApp.application.usecase.customer;

import com.jfjara.beautyapp.beautyApp.domain.model.Customer;
import com.jfjara.beautyapp.beautyApp.domain.model.exception.EmptyCustomerException;
import com.jfjara.beautyapp.beautyApp.domain.port.repository.CustomerRepository;
import com.jfjara.beautyapp.beautyApp.domain.port.usecase.customer.AddCustomer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class AddCustomerUseCase implements AddCustomer {

    private final CustomerRepository customerRepository;

    @Override
    public void execute(final Customer customer) throws EmptyCustomerException {
        log.debug(":: Add new customer {} ::", customer);
        var customerUpdated = customer.toBuilder()
                .internalId(System.currentTimeMillis())
                .build();
        customerRepository.add(customerUpdated);
    }

}
