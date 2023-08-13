package com.jfjara.beautyapp.beautyApp.infrastructure.mysql.mapper;

import com.jfjara.beautyapp.beautyApp.domain.model.Customer;
import com.jfjara.beautyapp.beautyApp.infrastructure.mysql.entity.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    Customer toModel(final CustomerEntity customerEntity);

    List<Customer> toModel(final List<CustomerEntity> customerEntities);
    CustomerEntity toEntity(final Customer customer);

}
