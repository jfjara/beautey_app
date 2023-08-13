package com.jfjara.beautyapp.beautyApp.infrastructure.mysql.repository;

import com.jfjara.beautyapp.beautyApp.domain.model.Customer;
import com.jfjara.beautyapp.beautyApp.domain.port.repository.CustomerRepository;
import com.jfjara.beautyapp.beautyApp.infrastructure.mysql.client.CustomerMySQLClient;
import com.jfjara.beautyapp.beautyApp.infrastructure.mysql.mapper.CustomerEntityMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CustomerMySQLRepository implements CustomerRepository {

    private final CustomerMySQLClient client;

    private final CustomerEntityMapper customerMapper;

    @Override
    public Optional<Customer> findById(final Long internalId) {
        var customer = client.findByInternalId(internalId);
        return customer.map(customerMapper::toModel);
    }

    @Override
    public Optional<List<Customer>> findAll() {
        return Optional.ofNullable(customerMapper.toModel(client.findAll()));
    }

    @Override
    public Optional<Customer> update(final Customer customer) {
        var customerRecoveredOptional = client.findByInternalId(customer.getInternalId());
        var customerUpdatedOptional = customerRecoveredOptional
                .map(customerRecovered -> customerRecovered.updateFields(customerMapper.toEntity(customer)))
                .map(client::save);
        return customerUpdatedOptional.map(customerMapper::toModel);
    }

    @Override
    public void add(final Customer customer) {
        var entity = customerMapper.toEntity(customer);
        customerMapper.toModel(client.save(entity));
    }
}
