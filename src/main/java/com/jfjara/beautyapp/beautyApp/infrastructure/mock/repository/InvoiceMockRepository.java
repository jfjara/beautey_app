package com.jfjara.beautyapp.beautyApp.infrastructure.mock.repository;

import com.jfjara.beautyapp.beautyApp.domain.model.Invoice;
import com.jfjara.beautyapp.beautyApp.domain.port.repository.InvoiceRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class InvoiceMockRepository implements InvoiceRepository {
    @Override
    public Optional<Invoice> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Invoice>> findByDateRange(LocalDate startDate, LocalDate endDate) {
        return Optional.empty();
    }

    @Override
    public Invoice add(Invoice invoice) {
        return null;
    }

    @Override
    public Invoice update(Invoice invoice) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
