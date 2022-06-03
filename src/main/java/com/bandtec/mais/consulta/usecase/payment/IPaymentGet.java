package com.bandtec.mais.consulta.usecase.payment;

import com.bandtec.mais.consulta.Credentials;

import java.util.Map;

public interface IPaymentGet {
    Map<String, Object> execute(Credentials credentials);
}
