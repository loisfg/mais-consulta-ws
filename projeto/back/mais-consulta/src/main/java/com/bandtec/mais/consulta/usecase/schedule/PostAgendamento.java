package com.bandtec.mais.consulta.usecase.schedule;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoRequestDTO;

public interface PostAgendamento {
    Agendamento execute(AgendamentoRequestDTO agendamentoRequestDTO);
}
