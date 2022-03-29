package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.models.PilhaObj;
import com.bandtec.mais.consulta.models.dto.NotificationDTO;
import com.bandtec.mais.consulta.usecase.notification.GetNotification;
import com.bandtec.mais.consulta.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("notification")
public class NotificationController {

    @Autowired
    private GetNotification getNotification;

    @Autowired
    private Validation validation;

    @GetMapping("/{idUser}")
    public ResponseEntity<PilhaObj<NotificationDTO>> getNotifications(@PathVariable Integer idUser) {
        validation.verifyPatient(idUser);
        return ResponseEntity.of(getNotification.execute(idUser));
    }

}
