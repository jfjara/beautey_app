package com.jfjara.beautyapp.beautyApp.infrastructure.mysql.repository;

import com.jfjara.beautyapp.beautyApp.domain.model.Service;
import com.jfjara.beautyapp.beautyApp.domain.port.repository.ServiceRepository;
import com.jfjara.beautyapp.beautyApp.infrastructure.mysql.client.ServiceMySQLClient;
import com.jfjara.beautyapp.beautyApp.infrastructure.mysql.mapper.ServiceEntityMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ServiceMySQLRepository implements ServiceRepository {

    private final ServiceMySQLClient client;

    private final ServiceEntityMapper serviceMapper;

    @Override
    public Optional<Service> findById(final Long id) {
        return client.findById(id).map(serviceMapper::toModel);
    }

    @Override
    public Optional<List<Service>> findAll() {
        return Optional.ofNullable(serviceMapper.toModel(client.findAll()));
    }

    @Override
    public void add(final Service service) {
        client.save(serviceMapper.toEntity(service));
    }

    @Override
    public Optional<Service> update(final Service service) {
        var serviceToUpdateOptional = client.findById(service.getId());
        return serviceToUpdateOptional
                .map(serviceToUpdate -> serviceToUpdate.update(serviceMapper.toEntity(service)))
                .map(client::save)
                .map(serviceMapper::toModel);
    }

}
