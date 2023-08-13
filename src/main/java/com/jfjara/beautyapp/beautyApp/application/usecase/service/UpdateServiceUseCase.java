package com.jfjara.beautyapp.beautyApp.application.usecase.service;

import com.jfjara.beautyapp.beautyApp.domain.model.Service;
import com.jfjara.beautyapp.beautyApp.domain.port.repository.ServiceRepository;
import com.jfjara.beautyapp.beautyApp.domain.port.usecase.service.UpdateService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateServiceUseCase implements UpdateService {

    private final ServiceRepository serviceRepository;

    @Override
    public Service execute(final Service service) {
        return serviceRepository.update(service);
    }
}
