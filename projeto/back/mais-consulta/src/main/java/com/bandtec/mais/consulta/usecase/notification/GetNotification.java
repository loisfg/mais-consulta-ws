package com.bandtec.mais.consulta.usecase.notification;

import com.bandtec.mais.consulta.models.PilhaObj;
import com.bandtec.mais.consulta.models.dto.NotificationDTO;

public interface GetNotification {
    PilhaObj<NotificationDTO> execute(Integer idUser);
}
