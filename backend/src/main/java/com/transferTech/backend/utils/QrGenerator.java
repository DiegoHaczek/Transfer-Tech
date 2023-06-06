package com.transferTech.backend.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.transferTech.backend.entity.Account;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QrGenerator {

    public static String generateQr(Long userId){
        //String qrPath = System.getProperty("user.dir")+"/src/main/resources/static/images/qr/";
        String qrPath= "/media/";
        String qrName = qrPath + userId + "qr.png";
        var qrCodeWriter = new QRCodeWriter();

        try{
        BitMatrix bitMatrix = qrCodeWriter.encode("id: " + userId,
                BarcodeFormat.QR_CODE, 400,400);
        Path path = FileSystems.getDefault().getPath(qrName);
        MatrixToImageWriter.writeToPath(bitMatrix,"PNG",path);
        }catch (IOException | WriterException e){
            throw new RuntimeException("There was a problem generating the QR code");
        }

        return System.getenv("URL_PATH") + userId + "qr.png";
    }
}
