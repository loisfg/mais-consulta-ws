package com.bandtec.mais.consulta.infra.queue.impl;

import com.bandtec.mais.consulta.infra.queue.FilaAgendamento;
import com.bandtec.mais.consulta.models.FilaObj;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class FilaAgendamentoImpl implements FilaAgendamento {

    FilaObj<Object> filaAgendamento = new FilaObj<>(100000);

    @Override
    public FilaObj<?> getFilaAgendamento() {
        return filaAgendamento;
    }

    @Override
    public void setFilaAgendamento(FilaObj<?> filaAgendamento) {
        this.filaAgendamento.insert(filaAgendamento.getFila());
    }

}
