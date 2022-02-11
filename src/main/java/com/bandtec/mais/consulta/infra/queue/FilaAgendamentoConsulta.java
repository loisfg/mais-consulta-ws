package com.bandtec.mais.consulta.infra.queue;

import com.bandtec.mais.consulta.models.FilaObj;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoConsultaRequestDTO;

public interface FilaAgendamentoConsulta {
    FilaObj<AgendamentoConsultaRequestDTO> getFilaAgendamentoConsulta();
    void setFilaAgendamentoConsulta(AgendamentoConsultaRequestDTO agendamentoConsultaRequestDTO);
}
