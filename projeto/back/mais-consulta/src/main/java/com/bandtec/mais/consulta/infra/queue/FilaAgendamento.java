package com.bandtec.mais.consulta.infra.queue;

import com.bandtec.mais.consulta.models.FilaObj;
import org.springframework.stereotype.Component;

public interface FilaAgendamento {
    FilaObj<?> getFilaAgendamento();
    void setFilaAgendamento(FilaObj<?> fileAgendamento);
}
