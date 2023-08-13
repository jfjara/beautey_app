package com.jfjara.beautyapp.beautyApp.domain.port.repository;

import com.jfjara.beautyapp.beautyApp.domain.model.Service;

import java.util.List;

public interface ServiceRepository {

    Service findById(final Long id);
    List<Service> findAll();

    Service add(final Service service);

    Service update(final Service service);

    void delete(final Long id);
}
