package com.bandtec.mais.consulta.usecase.notification;

import com.bandtec.mais.consulta.domain.Agendamento;

public interface CreateNotification {

    void execute(Agendamento agendamento, String consulta);
}
