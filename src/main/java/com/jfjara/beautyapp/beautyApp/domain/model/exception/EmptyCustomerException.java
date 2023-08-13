package com.jfjara.beautyapp.beautyApp.domain.model.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Builder
@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmptyCustomerException extends Exception {

    private String message;
    private String error;

}
