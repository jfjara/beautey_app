package com.jfjara.beautyapp.beautyApp.application.usecase.service;

import com.jfjara.beautyapp.beautyApp.domain.port.repository.ServiceRepository;
import com.jfjara.beautyapp.beautyApp.domain.port.usecase.service.DeleteService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteServiceUseCase implements DeleteService {

    private final ServiceRepository serviceRepository;

    @Override
    public void execute(final Long id) {
        serviceRepository.delete(id);
    }
}
