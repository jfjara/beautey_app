package com.jfjara.beautyapp.beautyApp.domain.port.usecase.invoice;

import com.jfjara.beautyapp.beautyApp.domain.model.Invoice;

public interface AddInvoice {

    Invoice execute(final Invoice invoice);
}
