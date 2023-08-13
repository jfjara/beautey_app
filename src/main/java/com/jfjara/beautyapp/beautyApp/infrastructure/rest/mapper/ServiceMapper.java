package com.jfjara.beautyapp.beautyApp.infrastructure.rest.mapper;

import com.jfjara.beautyapp.beautyApp.domain.model.Service;
import com.jfjara.beautyapp.beautyApp.infrastructure.rest.model.ServiceDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServiceMapper {

    ServiceDTO toDto(final Service service);
    List<ServiceDTO> toDto(final List<Service> service);

    Service toDomainModel(final ServiceDTO serviceDTO);

}
