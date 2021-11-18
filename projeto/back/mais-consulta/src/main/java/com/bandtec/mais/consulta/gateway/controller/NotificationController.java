package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.models.PilhaObj;
import com.bandtec.mais.consulta.models.dto.NotificationDTO;
import com.bandtec.mais.consulta.usecase.notification.GetNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("notification")
public class NotificationController {

    @Autowired
    private GetNotification getNotification;

    @GetMapping("/{idUser}")
    public ResponseEntity<PilhaObj<NotificationDTO>> getNotifications(@PathVariable Integer idUser) {
        return ResponseEntity.ok().body(getNotification.execute(idUser));
    }

}
