package com.jfjara.beautyapp.beautyApp.infrastructure.spring.conversor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class LocalDateConversor {

    public LocalDate toLocalDate(final String date) {
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(date, dtf);
    }
}
