package com.bandtec.mais.consulta.infra.queue.impl;

import com.bandtec.mais.consulta.infra.queue.FilaAgendamentoExame;
import com.bandtec.mais.consulta.models.FilaObj;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoExameRequestDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class FilaAgendamentoExameImpl implements FilaAgendamentoExame {

    FilaObj<AgendamentoExameRequestDTO> filaAgendamentoExame = new FilaObj<>(100000);

    @Override
    public FilaObj<AgendamentoExameRequestDTO> getFilaAgendamentoExame() {
        return filaAgendamentoExame;
    }

    @Override
    public void setFilaAgendamentoExame(AgendamentoExameRequestDTO agendamentoExameRequestDTO) {
        this.filaAgendamentoExame.insert(agendamentoExameRequestDTO);
    }

}
