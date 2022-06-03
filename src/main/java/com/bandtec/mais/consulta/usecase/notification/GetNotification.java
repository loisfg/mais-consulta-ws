package com.bandtec.mais.consulta.usecase.notification;

import com.bandtec.mais.consulta.models.StackObj;
import com.bandtec.mais.consulta.models.dto.NotificationDTO;

import java.util.Optional;

public interface GetNotification {
    Optional<StackObj<NotificationDTO>> execute(Integer userId);
}
