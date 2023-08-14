package com.jfjara.beautyapp.beautyApp.application.usecase.service;

import com.jfjara.beautyapp.beautyApp.domain.model.Service;
import com.jfjara.beautyapp.beautyApp.domain.model.exception.ServiceNotFoundException;
import com.jfjara.beautyapp.beautyApp.domain.port.repository.ServiceRepository;
import com.jfjara.beautyapp.beautyApp.domain.port.usecase.service.UpdateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class UpdateServiceUseCase implements UpdateService {

    private final ServiceRepository serviceRepository;

    @Override
    public Service execute(final Service service) throws ServiceNotFoundException {
        log.debug(":: Update service {} ::", service);
        return serviceRepository.update(service).orElseThrow(() ->
                ServiceNotFoundException.builder().message(String.format("Service %s not found", service.getId())).build());
    }
}
