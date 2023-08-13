package com.jfjara.beautyapp.beautyApp.application.usecase.customer;

import com.jfjara.beautyapp.beautyApp.domain.model.Customer;
import com.jfjara.beautyapp.beautyApp.domain.model.exception.CustomerNotFoundException;
import com.jfjara.beautyapp.beautyApp.domain.port.repository.CustomerRepository;
import com.jfjara.beautyapp.beautyApp.domain.port.usecase.customer.FindAllCustomers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class FindAllCustomersUseCase implements FindAllCustomers {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> execute() throws CustomerNotFoundException {
        log.debug(":: Find all customers :: ");
        return customerRepository.findAll()
                .orElseThrow(() -> CustomerNotFoundException.builder().message("No customers found").build());
    }
}
