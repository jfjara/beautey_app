package com.jfjara.beautyapp.beautyApp.infrastructure.rest.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorDTO {
    private String message;
    private int code;
}
