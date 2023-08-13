package com.jfjara.beautyapp.beautyApp.domain.model.exception;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class InvoiceNotFoundException extends Exception {
    private String message;
}