package com.bandtec.mais.consulta.factory;

import com.bandtec.mais.consulta.domain.Scheduling;

public interface NotificationAdapter {
    String getType();

    String buildNotificationMessage(Scheduling scheduling);
}
