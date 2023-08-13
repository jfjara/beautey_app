package com.jfjara.beautyapp.beautyApp.infrastructure.rest.controller;

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
    private DeleteService deleteService;

    @Autowired
    private ServiceMapper serviceMapper;

    @GetMapping("v1/services/{servicesId}")
    public ResponseEntity<ServiceDTO> findById(@PathVariable("servicesId") final Long serviceId) {
        return ResponseEntity.ok(serviceMapper.toDto(findServiceById.execute(serviceId)));
    }

    @GetMapping("v1/services")
    public ResponseEntity<List<ServiceDTO>> findAll() {
        return ResponseEntity.ok(serviceMapper.toDto(findAllServices.execute()));
    }

    @PostMapping(path = "v1/services")
    public ResponseEntity<ServiceDTO> add(@RequestBody final ServiceDTO serviceDTO) {
        return new ResponseEntity(serviceMapper.toDto(
                addService.execute(serviceMapper.toDomainModel(serviceDTO))),
                HttpStatus.CREATED);
    }

    @PutMapping(path = "v1/services")
    public ResponseEntity<ServiceDTO> update(@RequestBody final ServiceDTO serviceDTO) {
        return new ResponseEntity(serviceMapper.toDto(
                updateService.execute(serviceMapper.toDomainModel(serviceDTO))),
                HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "v1/services/{serviceId}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("serviceId") final Long serviceId) {
        deleteService.execute(serviceId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
