package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.domain.Email;
import com.bandtec.mais.consulta.models.dto.request.EmailDTO;
import com.bandtec.mais.consulta.usecase.email.EmailSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("email")
public class EmailController {

    @Autowired
    EmailSend emailSend;

    @PostMapping("/sending-email/{patientId}")
    public ResponseEntity<Email> sendingEmail(@RequestBody @Valid EmailDTO emailDto,
                                              @PathVariable Integer patientId) {
        return new ResponseEntity<>(emailSend.execute(emailDto, patientId), HttpStatus.CREATED);
    }
}
