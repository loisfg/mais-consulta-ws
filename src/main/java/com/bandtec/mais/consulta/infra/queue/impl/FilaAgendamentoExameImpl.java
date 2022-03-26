package com.bandtec.mais.consulta.infra.queue.impl;

import com.bandtec.mais.consulta.infra.queue.FilaAgendamentoExame;
import com.bandtec.mais.consulta.models.FilaObj;
import com.bandtec.mais.consulta.models.dto.request.ExamSchedulingRequestDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class FilaAgendamentoExameImpl implements FilaAgendamentoExame {

    FilaObj<ExamSchedulingRequestDTO> filaAgendamentoExame = new FilaObj<>(100000);

    @Override
    public FilaObj<ExamSchedulingRequestDTO> getFilaAgendamentoExame() {
        return filaAgendamentoExame;
    }

    @Override
    public void setFilaAgendamentoExame(ExamSchedulingRequestDTO examSchedulingRequestDTO) {
        this.filaAgendamentoExame.insert(examSchedulingRequestDTO);



    }

}
