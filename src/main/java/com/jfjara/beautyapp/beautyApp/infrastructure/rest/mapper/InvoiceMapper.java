package com.jfjara.beautyapp.beautyApp.infrastructure.rest.mapper;

import com.jfjara.beautyapp.beautyApp.domain.model.Invoice;
import com.jfjara.beautyapp.beautyApp.infrastructure.rest.model.InvoiceDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    InvoiceDTO toDto(final Invoice invoice);
    List<InvoiceDTO> toDto(final List<Invoice> invoice);
    Invoice toDomainModel(final InvoiceDTO invoiceDTO);

}
