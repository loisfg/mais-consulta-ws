package com.bandtec.mais.consulta.usecase.schedule;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoExameRequestDTO;

public interface PostAgendamentoExame {
    Agendamento execute(AgendamentoExameRequestDTO agendamentoExameRequestDTO);
}
