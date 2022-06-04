package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.Credentials;
import com.bandtec.mais.consulta.models.dto.request.PaymentPostRequestDTO;
import com.bandtec.mais.consulta.usecase.payment.pix.GetQrCodePixDetail;
import com.bandtec.mais.consulta.usecase.payment.pix.GetQrCodePixIPayment;
import com.bandtec.mais.consulta.usecase.payment.pix.PaymentPixGetList;
import com.bandtec.mais.consulta.usecase.payment.pix.PaymentPixPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("payment")
public class PaymentController {

    Credentials credentials = new Credentials();

    @Autowired
    PaymentPixGetList iPaymentGet;
    @Autowired
    PaymentPixPost iPaymentPost;
    @Autowired
    GetQrCodePixIPayment iPaymentGetQr;
    @Autowired
    GetQrCodePixDetail iPaymentGetQrDetail;


    @GetMapping
    public ResponseEntity<Map<String, Object>> getPixPayment() {
        return ResponseEntity.ok(iPaymentGet.execute(credentials));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> postPixPayment(
            @RequestBody PaymentPostRequestDTO paymentPostRequestDTO
    ) {
        return ResponseEntity.ok(iPaymentPost.execute(credentials, paymentPostRequestDTO));
    }

    @GetMapping("/qrcode/{id}")
    public ResponseEntity<Map<String, Object>> getQrCodePixPayment(@PathVariable String id) {
        return ResponseEntity.ok(iPaymentGetQr.execute(credentials, id));
    }

    @GetMapping("/qrcode/detail/{id}")
    public ResponseEntity<Map<String, Object>> getQrCodePixPaymentDetail(@PathVariable String id) {
        return ResponseEntity.ok(iPaymentGetQrDetail.execute(credentials, id));
    }
}
