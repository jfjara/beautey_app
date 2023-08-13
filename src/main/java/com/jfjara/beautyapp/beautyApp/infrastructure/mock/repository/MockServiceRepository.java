package com.jfjara.beautyapp.beautyApp.infrastructure.mock.repository;

import com.jfjara.beautyapp.beautyApp.domain.model.Service;
import com.jfjara.beautyapp.beautyApp.domain.port.repository.ServiceRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MockServiceRepository implements ServiceRepository {
    @Override
    public Service findById(Long id) {
        return Service.builder().build();
    }

    @Override
    public List<Service> findAll() {
        return List.of(Service.builder().build(), Service.builder().build());
    }

    @Override
    public Service add(final Service service) {
        return service;
    }

    @Override
    public Service update(final Service service) {
        return service;
    }

    @Override
    public void delete(final Long id) {

    }
}
