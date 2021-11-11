package com.bandtec.mais.consulta.factory.impl;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.factory.NotificationAdapter;
import org.springframework.stereotype.Service;

@Service
public class ConsultaNotificationAdapterImpl implements NotificationAdapter {
    @Override
    public String getType() {
        return "consulta";
    }

    @Override
    public String getNotificationMessage(Agendamento agendamento) {
        return null;
    }
}
