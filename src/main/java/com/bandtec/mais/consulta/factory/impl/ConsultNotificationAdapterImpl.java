package com.bandtec.mais.consulta.factory.impl;

import com.bandtec.mais.consulta.domain.Scheduling;
import com.bandtec.mais.consulta.factory.NotificationAdapter;
import org.springframework.stereotype.Service;

@Service
public class ConsultNotificationAdapterImpl implements NotificationAdapter {
    @Override
    public String getType() {
        return "consulta";
    }

    @Override
    public String buildNotificationMessage(Scheduling scheduling) {

        StringBuilder notificationMessage = new StringBuilder();

        notificationMessage.append("");

        return notificationMessage.toString();
    }
}
