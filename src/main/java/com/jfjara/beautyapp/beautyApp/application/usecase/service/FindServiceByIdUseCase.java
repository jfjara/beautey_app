package com.jfjara.beautyapp.beautyApp.application.usecase.service;

import com.jfjara.beautyapp.beautyApp.domain.model.Service;
import com.jfjara.beautyapp.beautyApp.domain.model.exception.ServiceNotFoundException;
import com.jfjara.beautyapp.beautyApp.domain.port.repository.ServiceRepository;
import com.jfjara.beautyapp.beautyApp.domain.port.usecase.service.FindServiceById;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class FindServiceByIdUseCase implements FindServiceById {
    private final ServiceRepository serviceRepository;
    @Override
    public Service execute(final Long id) throws ServiceNotFoundException {
        log.debug(":: Find service by id {}", id);
        return serviceRepository.findById(id).orElseThrow(() ->
                ServiceNotFoundException.builder().message(String.format("Service %s not found", id)).build());
    }
}
