package com.bandtec.mais.consulta.usecase.payment;

import com.bandtec.mais.consulta.Credentials;
import com.bandtec.mais.consulta.models.dto.request.PaymentPostRequestDTO;

import java.util.Map;

public interface IPaymentPost {
    Map<String, Object> execute(Credentials credentials, PaymentPostRequestDTO paymentPostRequestDTO);
}
