package com.bandtec.mais.consulta.infra.queue;

import com.bandtec.mais.consulta.models.FilaObj;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoConsultaRequestDTO;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoExameRequestDTO;
import org.springframework.stereotype.Component;

public interface FilaAgendamentoExame {
    FilaObj<AgendamentoExameRequestDTO> getFilaAgendamentoExame();
    void setFilaAgendamentoExame(AgendamentoExameRequestDTO agendamentoExameRequestDTO);
}
