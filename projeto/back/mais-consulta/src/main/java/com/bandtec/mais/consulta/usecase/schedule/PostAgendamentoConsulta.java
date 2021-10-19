package com.bandtec.mais.consulta.usecase.schedule;

import com.bandtec.mais.consulta.domain.Consulta;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoConsultaRequestDTO;

import java.util.Optional;

public interface PostAgendamentoConsulta {
    Optional<Consulta> execute(AgendamentoConsultaRequestDTO agendamentoConsultaRequestDTO);
}
