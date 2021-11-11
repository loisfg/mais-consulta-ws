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
    public String getNotificationMessage(Agendamento agendamento) {
        return null;
    }
}
