package com.jfjara.beautyapp.beautyApp.infrastructure.rest.controller;

import com.jfjara.beautyapp.beautyApp.domain.model.exception.CustomerNotFoundException;
import com.jfjara.beautyapp.beautyApp.domain.model.exception.EmptyCustomerException;
import com.jfjara.beautyapp.beautyApp.domain.port.usecase.customer.*;
import com.jfjara.beautyapp.beautyApp.infrastructure.rest.mapper.CustomerMapper;
import com.jfjara.beautyapp.beautyApp.infrastructure.rest.model.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
public class CustomerController {

    @Autowired
    private FindCustomerById findCustomerById;

    @Autowired
    private FindAllCustomers findAllCustomers;

    @Autowired
    private GenerateCustomerQR generateCustomerQR;

    @Autowired
    private AddCustomer addCustomer;

    @Autowired
    private UpdateCustomer updateCustomer;

    @Autowired
    private CustomerMapper customerMapper;

    @GetMapping("v1/customers/{customerId}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable("customerId") final Long customerId) throws CustomerNotFoundException {
        return ResponseEntity.ok(customerMapper.toDto(findCustomerById.execute(customerId)));
    }

    @GetMapping("v1/customers")
    public ResponseEntity<List<CustomerDTO>> findAll() throws CustomerNotFoundException {
        return ResponseEntity.ok(customerMapper.toDto(findAllCustomers.execute()));
    }

    @GetMapping(path = "v1/customers/{customerId}/qr", produces = "image/png")
    public ResponseEntity<byte[]> generateQR(@PathVariable("customerId") final Long customerId) throws IOException {
        return ResponseEntity.status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_DISPOSITION, "filename=\"qr.png\"")
                .contentType(MediaType.IMAGE_PNG)
                .body(generateCustomerQR.execute(customerId));
    }

    @PostMapping(path = "v1/customers")
    public ResponseEntity<CustomerDTO> add(@RequestBody final CustomerDTO customerDTO) throws EmptyCustomerException {
        addCustomer.execute(customerMapper.toDomainModel(customerDTO));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping(path = "v1/customers")
    public ResponseEntity<HttpStatus> update(@RequestBody final CustomerDTO customerDTO)
            throws CustomerNotFoundException {
        return new ResponseEntity(
                customerMapper.toDto(updateCustomer.execute(customerMapper.toDomainModel(customerDTO))),
                HttpStatus.CREATED);
    }


}
