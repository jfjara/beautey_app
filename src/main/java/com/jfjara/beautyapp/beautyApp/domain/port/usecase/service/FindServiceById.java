package com.jfjara.beautyapp.beautyApp.domain.port.usecase.service;

import com.jfjara.beautyapp.beautyApp.domain.model.Service;
import com.jfjara.beautyapp.beautyApp.domain.model.exception.ServiceNotFoundException;

public interface FindServiceById {

    Service execute(final Long id) throws ServiceNotFoundException;
}
