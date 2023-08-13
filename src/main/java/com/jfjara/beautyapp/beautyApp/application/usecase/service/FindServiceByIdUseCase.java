package com.jfjara.beautyapp.beautyApp.application.usecase.service;

import com.jfjara.beautyapp.beautyApp.domain.model.Service;
import com.jfjara.beautyapp.beautyApp.domain.port.repository.ServiceRepository;
import com.jfjara.beautyapp.beautyApp.domain.port.usecase.service.FindServiceById;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindServiceByIdUseCase implements FindServiceById {
    private final ServiceRepository serviceRepository;
    @Override
    public Service execute(final Long id) {
        return serviceRepository.findById(id);
    }
}
