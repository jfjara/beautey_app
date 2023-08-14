package com.jfjara.beautyapp.beautyApp.domain.port.usecase.service;

import com.jfjara.beautyapp.beautyApp.domain.model.Service;
import com.jfjara.beautyapp.beautyApp.domain.model.exception.ServiceNotFoundException;

public interface UpdateService {

    Service execute(final Service service) throws ServiceNotFoundException;
}
