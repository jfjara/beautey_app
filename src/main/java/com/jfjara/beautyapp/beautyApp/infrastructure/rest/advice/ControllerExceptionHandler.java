package com.jfjara.beautyapp.beautyApp.infrastructure.rest.advice;

import com.jfjara.beautyapp.beautyApp.domain.model.exception.CustomerNotFoundException;
import com.jfjara.beautyapp.beautyApp.domain.model.exception.EmptyCustomerException;
import com.jfjara.beautyapp.beautyApp.domain.model.exception.GenerateQRException;
import com.jfjara.beautyapp.beautyApp.domain.model.exception.InvoiceNotFoundException;
import com.jfjara.beautyapp.beautyApp.infrastructure.rest.model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorDTO> customerNotFoundExceptionHandle(final CustomerNotFoundException exception,
                                                           final WebRequest webRequest) {
        return new ResponseEntity(ErrorDTO.builder().code(404).message(exception.getMessage()).build(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GenerateQRException.class)
    public ResponseEntity<ErrorDTO> generateQRExceptionHandle(final GenerateQRException exception,
                                                           final WebRequest webRequest) {
        return new ResponseEntity(ErrorDTO.builder().code(580).message(exception.getMessage()).build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvoiceNotFoundException.class)
    public ResponseEntity<ErrorDTO> invoiceNotFoundExceptionHandle(final InvoiceNotFoundException exception,
                                                                    final WebRequest webRequest) {
        return new ResponseEntity(ErrorDTO.builder().code(404).message(exception.getMessage()).build(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyCustomerException.class)
    public ResponseEntity<ErrorDTO> emptyCustomerExceptionHandle(final EmptyCustomerException exception,
                                                                   final WebRequest webRequest) {
        return new ResponseEntity(ErrorDTO.builder().code(401).message(exception.getMessage()).build(),
                HttpStatus.BAD_REQUEST);
    }




}
