package com.jfjara.beautyapp.beautyApp.infrastructure.rest.controller;

import com.jfjara.beautyapp.beautyApp.domain.model.exception.ServiceNotFoundException;
import com.jfjara.beautyapp.beautyApp.domain.port.usecase.service.*;
import com.jfjara.beautyapp.beautyApp.infrastructure.rest.mapper.ServiceMapper;
import com.jfjara.beautyapp.beautyApp.infrastructure.rest.model.ServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceController {

    @Autowired
    private FindServiceById findServiceById;

    @Autowired
    private FindAllServices findAllServices;

    @Autowired
    private AddService addService;

    @Autowired
    private UpdateService updateService;

    @Autowired
    private ServiceMapper serviceMapper;

    @GetMapping("v1/services/{servicesId}")
    public ResponseEntity<ServiceDTO> findById(@PathVariable("servicesId") final Long serviceId)
            throws ServiceNotFoundException {
        return ResponseEntity.ok(serviceMapper.toDto(findServiceById.execute(serviceId)));
    }

    @GetMapping("v1/services")
    public ResponseEntity<List<ServiceDTO>> findAll() throws ServiceNotFoundException {
        return ResponseEntity.ok(serviceMapper.toDto(findAllServices.execute()));
    }

    @PostMapping(path = "v1/services")
    public ResponseEntity<ServiceDTO> add(@RequestBody final ServiceDTO serviceDTO) {
        addService.execute(serviceMapper.toDomainModel(serviceDTO));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping(path = "v1/services")
    public ResponseEntity<ServiceDTO> update(@RequestBody final ServiceDTO serviceDTO)
            throws ServiceNotFoundException {
        return new ResponseEntity(serviceMapper.toDto(
                updateService.execute(serviceMapper.toDomainModel(serviceDTO))),
                HttpStatus.ACCEPTED);
    }

}
