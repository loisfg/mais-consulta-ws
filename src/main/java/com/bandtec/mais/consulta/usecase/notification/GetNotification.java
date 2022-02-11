package com.bandtec.mais.consulta.usecase.notification;

import com.bandtec.mais.consulta.models.PilhaObj;
import com.bandtec.mais.consulta.models.dto.NotificationDTO;

import java.util.Optional;

public interface GetNotification {
    Optional<PilhaObj<NotificationDTO>> execute(Integer idUser);
}
