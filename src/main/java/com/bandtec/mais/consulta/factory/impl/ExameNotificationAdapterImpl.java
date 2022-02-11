package com.bandtec.mais.consulta.factory.impl;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.factory.NotificationAdapter;
import org.springframework.stereotype.Service;

@Service
public class ExameNotificationAdapterImpl implements NotificationAdapter {
    @Override
    public String getType() {
        return "exame";
    }

    @Override
    public String buildNotificationMessage(Agendamento agendamento) {

        StringBuilder notificationMessage = new StringBuilder();

        notificationMessage.append("");

        return notificationMessage.toString();
    }
}