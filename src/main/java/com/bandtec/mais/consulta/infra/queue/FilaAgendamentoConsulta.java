package com.bandtec.mais.consulta.infra.queue;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.domain.Consulta;
import com.bandtec.mais.consulta.models.FilaObj;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoConsultaRequestDTO;

import java.util.List;

public interface FilaAgendamentoConsulta {
    FilaObj<Consulta> getFilaAgendamentoConsulta();
    void setFilaAgendamentoConsulta(Consulta consulta);
}
