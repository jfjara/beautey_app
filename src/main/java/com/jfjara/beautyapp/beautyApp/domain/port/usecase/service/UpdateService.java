package com.jfjara.beautyapp.beautyApp.domain.port.usecase.service;

import com.jfjara.beautyapp.beautyApp.domain.model.Service;

public interface UpdateService {

    Service execute(final Service service);
}
