package com.bandtec.mais.consulta.usecase.schedule;

import com.bandtec.mais.consulta.domain.Exame;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoExameRequestDTO;

import java.util.Optional;

public interface PostAgendamentoExame {
    Optional<Exame> execute(AgendamentoExameRequestDTO agendamentoExameRequestDTO);
}
