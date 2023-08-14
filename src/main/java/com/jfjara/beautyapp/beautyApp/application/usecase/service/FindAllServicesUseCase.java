package com.jfjara.beautyapp.beautyApp.application.usecase.service;

import com.jfjara.beautyapp.beautyApp.domain.model.Service;
import com.jfjara.beautyapp.beautyApp.domain.model.exception.ServiceNotFoundException;
import com.jfjara.beautyapp.beautyApp.domain.port.repository.ServiceRepository;
import com.jfjara.beautyapp.beautyApp.domain.port.usecase.service.FindAllServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class FindAllServicesUseCase implements FindAllServices {

    private final ServiceRepository serviceRepository;

    @Override
    public List<Service> execute() throws ServiceNotFoundException {
        log.debug(":: Find all services ::");
        return serviceRepository.findAll().orElseThrow(() ->
                ServiceNotFoundException.builder().message("Services not found").build());
    }
}
