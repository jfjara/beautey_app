package com.jfjara.beautyapp.beautyApp.application.usecase.service;

import com.jfjara.beautyapp.beautyApp.domain.model.Service;
import com.jfjara.beautyapp.beautyApp.domain.port.repository.ServiceRepository;
import com.jfjara.beautyapp.beautyApp.domain.port.usecase.service.AddService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class AddServiceUseCase implements AddService {

    private final ServiceRepository serviceRepository;

    @Override
    public void execute(final Service service) {
        log.debug(":: Save new service {} ::", service);
        serviceRepository.add(service);
    }
}
