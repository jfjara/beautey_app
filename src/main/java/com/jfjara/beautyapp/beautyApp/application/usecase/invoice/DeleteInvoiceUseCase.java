package com.jfjara.beautyapp.beautyApp.application.usecase.invoice;

import com.jfjara.beautyapp.beautyApp.domain.port.repository.InvoiceRepository;
import com.jfjara.beautyapp.beautyApp.domain.port.usecase.invoice.DeleteInvoice;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteInvoiceUseCase implements DeleteInvoice {

    private final InvoiceRepository invoiceRepository;

    @Override
    public void execute(final Long id) {
        invoiceRepository.delete(id);
    }
}
