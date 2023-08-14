package com.jfjara.beautyapp.beautyApp.domain.port.repository;

import com.jfjara.beautyapp.beautyApp.domain.model.Service;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository {

    Optional<Service> findById(final Long id);
    Optional<List<Service>> findAll();

    void add(final Service service);

    Optional<Service> update(final Service service);

}
