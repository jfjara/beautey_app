package com.jfjara.beautyapp.beautyApp.domain.model.exception;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GenerateQRException extends RuntimeException {

    private String message;
    private String error;
}
