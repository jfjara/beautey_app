package com.jfjara.beautyapp.beautyApp.domain.port.repository;

import java.awt.image.BufferedImage;

public interface QRRepository {

    BufferedImage generate(final Long id);

}
