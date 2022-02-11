package com.bandtec.mais.consulta.infra.queue.impl;

import com.bandtec.mais.consulta.infra.queue.FilaAgendamentoConsulta;
import com.bandtec.mais.consulta.models.FilaObj;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoConsultaRequestDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class FilaAgendamentoConsultaImpl implements FilaAgendamentoConsulta {

    FilaObj<AgendamentoConsultaRequestDTO> filaAgendamentoConsulta = new FilaObj<>(1000000);

    @Override
    public FilaObj<AgendamentoConsultaRequestDTO> getFilaAgendamentoConsulta() {
        return filaAgendamentoConsulta;
    }

    @Override
    public void setFilaAgendamentoConsulta(AgendamentoConsultaRequestDTO agendamentoConsultaRequestDTO) {
        this.filaAgendamentoConsulta.insert(agendamentoConsultaRequestDTO);
    }
}
