package com.bandtec.mais.consulta.infra.queue;

import com.bandtec.mais.consulta.models.FilaObj;
import com.bandtec.mais.consulta.models.dto.request.ExamSchedulingRequestDTO;

public interface FilaAgendamentoExame {
    FilaObj<ExamSchedulingRequestDTO> getFilaAgendamentoExame();
    void setFilaAgendamentoExame(ExamSchedulingRequestDTO examSchedulingRequestDTO);
}
