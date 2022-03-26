package com.bandtec.mais.consulta.usecase.notification;

import com.bandtec.mais.consulta.domain.Scheduling;

public interface CreateNotification {
    void execute(Scheduling agendamento, String consulta);
}
