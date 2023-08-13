package com.jfjara.beautyapp.beautyApp.application.usecase.service;

import com.jfjara.beautyapp.beautyApp.domain.model.Service;
import com.jfjara.beautyapp.beautyApp.domain.port.repository.ServiceRepository;
import com.jfjara.beautyapp.beautyApp.domain.port.usecase.service.FindAllServices;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindAllServicesUseCase implements FindAllServices {

    private final ServiceRepository serviceRepository;

    @Override
    public List<Service> execute() {
        return serviceRepository.findAll();
    }
}
