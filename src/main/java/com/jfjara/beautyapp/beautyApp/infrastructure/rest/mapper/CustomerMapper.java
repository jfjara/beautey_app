package com.jfjara.beautyapp.beautyApp.infrastructure.rest.mapper;

import com.jfjara.beautyapp.beautyApp.domain.model.Customer;
import com.jfjara.beautyapp.beautyApp.infrastructure.rest.model.CustomerDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO toDto(final Customer customer);

    List<CustomerDTO> toDto(final List<Customer> customer);

    Customer toDomainModel(final CustomerDTO customerDTO);
}
