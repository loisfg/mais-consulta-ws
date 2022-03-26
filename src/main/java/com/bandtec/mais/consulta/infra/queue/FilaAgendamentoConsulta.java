package com.bandtec.mais.consulta.infra.queue;

import com.bandtec.mais.consulta.domain.Consult;
import com.bandtec.mais.consulta.models.FilaObj;

public interface FilaAgendamentoConsulta {
    FilaObj<Consult> getFilaAgendamentoConsulta();
    void setFilaAgendamentoConsulta(Consult consult);
}
