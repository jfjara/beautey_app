package com.jfjara.beautyapp.beautyApp.domain.port.usecase.service;

import com.jfjara.beautyapp.beautyApp.domain.model.Service;
import com.jfjara.beautyapp.beautyApp.domain.model.exception.ServiceNotFoundException;

import java.util.List;

public interface FindAllServices {

    List<Service> execute() throws ServiceNotFoundException;
}
