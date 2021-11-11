package com.bandtec.mais.consulta.factory;

import com.bandtec.mais.consulta.domain.Agendamento;

public interface NotificationAdapter {
    String getType();
    String getNotificationMessage(Agendamento agendamento);
}
