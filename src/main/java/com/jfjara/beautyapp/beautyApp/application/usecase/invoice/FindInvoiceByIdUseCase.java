package com.jfjara.beautyapp.beautyApp.application.usecase.invoice;

import com.jfjara.beautyapp.beautyApp.domain.model.Invoice;
import com.jfjara.beautyapp.beautyApp.domain.model.exception.InvoiceNotFoundException;
import com.jfjara.beautyapp.beautyApp.domain.port.repository.InvoiceRepository;
import com.jfjara.beautyapp.beautyApp.domain.port.usecase.invoice.FindInvoiceById;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindInvoiceByIdUseCase implements FindInvoiceById {

    private final InvoiceRepository invoiceRepository;

    @Override
    public Invoice execute(final Long id) throws InvoiceNotFoundException {
        return invoiceRepository.findById(id).orElseThrow(() -> InvoiceNotFoundException.builder().build());
    }
}
