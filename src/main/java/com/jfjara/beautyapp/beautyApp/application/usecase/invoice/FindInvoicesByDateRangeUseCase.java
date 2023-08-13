package com.jfjara.beautyapp.beautyApp.application.usecase.invoice;

import com.jfjara.beautyapp.beautyApp.domain.model.Invoice;
import com.jfjara.beautyapp.beautyApp.domain.model.exception.InvoiceNotFoundException;
import com.jfjara.beautyapp.beautyApp.domain.port.repository.InvoiceRepository;
import com.jfjara.beautyapp.beautyApp.domain.port.usecase.invoice.FindInvoicesByDateRange;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class FindInvoicesByDateRangeUseCase implements FindInvoicesByDateRange {

    private final InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> execute(final LocalDate startDate, final LocalDate endDate) throws InvoiceNotFoundException {
        return invoiceRepository.findByDateRange(startDate, endDate)
                .orElseThrow(() -> InvoiceNotFoundException.builder().build());
    }
}
