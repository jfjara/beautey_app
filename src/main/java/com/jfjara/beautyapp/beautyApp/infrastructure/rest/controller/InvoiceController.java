package com.jfjara.beautyapp.beautyApp.infrastructure.rest.controller;

import com.jfjara.beautyapp.beautyApp.domain.model.exception.InvoiceNotFoundException;
import com.jfjara.beautyapp.beautyApp.domain.port.usecase.invoice.*;
import com.jfjara.beautyapp.beautyApp.infrastructure.rest.mapper.InvoiceMapper;
import com.jfjara.beautyapp.beautyApp.infrastructure.rest.model.InvoiceDTO;
import com.jfjara.beautyapp.beautyApp.infrastructure.spring.conversor.LocalDateConversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    private FindInvoiceById findInvoiceById;

    @Autowired
    private FindInvoicesByDateRange findInvoicesByDateRange;

    @Autowired
    private AddInvoice addInvoice;

    @Autowired
    private UpdateInvoice updateInvoice;

    @Autowired
    private DeleteInvoice deleteInvoice;

    @Autowired
    private InvoiceMapper invoiceMapper;

    @Autowired
    private LocalDateConversor localDateConversor;

    @GetMapping("v1/invoices/{invoiceId}")
    public ResponseEntity<InvoiceDTO> getById(@PathVariable("invoiceId") final Long invoiceId) throws InvoiceNotFoundException {
        return ResponseEntity.ok(invoiceMapper.toDto(findInvoiceById.execute(invoiceId)));
    }

    @GetMapping("v1/invoices")
    public ResponseEntity<List<InvoiceDTO>> findByDateRange(
            @RequestParam("startDate") final String startDate,
            @RequestParam("endDate") final String endDate) throws InvoiceNotFoundException {
        return ResponseEntity.ok(invoiceMapper.toDto(
                findInvoicesByDateRange.execute(
                        localDateConversor.toLocalDate(startDate),
                        localDateConversor.toLocalDate(endDate))));
    }

    @PostMapping(path = "v1/invoices")
    public ResponseEntity<InvoiceDTO> add(@RequestBody final InvoiceDTO invoiceDTO) {
        return new ResponseEntity(
                invoiceMapper.toDto(addInvoice.execute(invoiceMapper.toDomainModel(invoiceDTO))),
                HttpStatus.CREATED);
    }

    @PutMapping(path = "v1/invoices")
    public ResponseEntity<InvoiceDTO> update(@RequestBody final InvoiceDTO invoiceDTO) {
        return new ResponseEntity(
                invoiceMapper.toDto(updateInvoice.execute(invoiceMapper.toDomainModel(invoiceDTO))),
                HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "v1/invoices/{invoiceId}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("invoiceId") final Long invoiceId) {
        deleteInvoice.execute(invoiceId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}
