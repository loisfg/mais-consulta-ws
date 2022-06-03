package com.bandtec.mais.consulta.usecase.payment.pix;

import com.bandtec.mais.consulta.Credentials;

import java.io.ByteArrayInputStream;

public interface PaymentGetQrCode {
    String execute(Credentials credentials, String id);
}
