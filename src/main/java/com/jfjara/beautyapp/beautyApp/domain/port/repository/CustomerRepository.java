package com.jfjara.beautyapp.beautyApp.domain.port.repository;

import com.jfjara.beautyapp.beautyApp.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    Optional<Customer> findById (final Long customerId);
    Optional<List<Customer>> findAll();

    Optional<Customer> update(final Customer customer);

    void add(final Customer customer);
}
