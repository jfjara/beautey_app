package com.jfjara.beautyapp.beautyApp.infrastructure.mysql.mapper;

import com.jfjara.beautyapp.beautyApp.domain.model.Service;
import com.jfjara.beautyapp.beautyApp.infrastructure.mysql.entity.ServiceEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServiceEntityMapper {

    ServiceEntity toEntity(final Service service);
    Service toModel(final ServiceEntity serviceDTO);
    List<Service> toModel(final List<ServiceEntity> serviceDTO);

}
