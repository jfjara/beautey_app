package com.jfjara.beautyapp.beautyApp.infrastructure.qr.repository;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.jfjara.beautyapp.beautyApp.domain.model.exception.GenerateQRException;
import com.jfjara.beautyapp.beautyApp.domain.port.repository.QRRepository;
import org.springframework.stereotype.Repository;

import java.awt.image.BufferedImage;

@Repository
public class ZXIngQRRepository implements QRRepository {

    @Override
    public BufferedImage generate(final Long id) {
        try {
            QRCodeWriter barcodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = barcodeWriter.encode(String.valueOf(id), BarcodeFormat.QR_CODE, 200, 200);
            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (WriterException e) {
            throw GenerateQRException.builder().message("Error generating QR code: " + e.getMessage()).build();
        }
    }
}
