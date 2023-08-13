package com.jfjara.beautyapp.beautyApp.domain.port.repository;

import com.jfjara.beautyapp.beautyApp.domain.model.Invoice;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface InvoiceRepository {

    Optional<Invoice> findById(final Long id);
    Optional<List<Invoice>> findByDateRange(final LocalDate startDate, final LocalDate endDate);

    Invoice add(final Invoice invoice);
    Invoice update(final Invoice invoice);
    void delete(final Long id);

}
