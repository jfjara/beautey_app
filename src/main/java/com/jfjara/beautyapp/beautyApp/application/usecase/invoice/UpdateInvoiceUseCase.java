package com.jfjara.beautyapp.beautyApp.application.usecase.invoice;

import com.jfjara.beautyapp.beautyApp.domain.model.Invoice;
import com.jfjara.beautyapp.beautyApp.domain.port.repository.InvoiceRepository;
import com.jfjara.beautyapp.beautyApp.domain.port.usecase.invoice.UpdateInvoice;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateInvoiceUseCase implements UpdateInvoice {

    private final InvoiceRepository invoiceRepository;

    @Override
    public Invoice execute(final Invoice invoice) {
        return invoiceRepository.update(invoice);
    }
}
