package com.jfjara.beautyapp.beautyApp.domain.port.usecase.invoice;

import com.jfjara.beautyapp.beautyApp.domain.model.Invoice;
import com.jfjara.beautyapp.beautyApp.domain.model.exception.InvoiceNotFoundException;

public interface FindInvoiceById {

    Invoice execute(final Long id) throws InvoiceNotFoundException;
}
