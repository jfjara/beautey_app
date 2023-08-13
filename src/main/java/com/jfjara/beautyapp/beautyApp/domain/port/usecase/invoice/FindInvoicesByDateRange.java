package com.jfjara.beautyapp.beautyApp.domain.port.usecase.invoice;

import com.jfjara.beautyapp.beautyApp.domain.model.Invoice;
import com.jfjara.beautyapp.beautyApp.domain.model.exception.InvoiceNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface FindInvoicesByDateRange {

    List<Invoice> execute(final LocalDate startDate, final LocalDate endDate) throws InvoiceNotFoundException;

}
