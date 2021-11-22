package com.bandtec.mais.consulta.usecase.schedule;

import com.bandtec.mais.consulta.models.dto.response.AgendamentoConsultaResponseDTO;

import java.util.List;
import java.util.Optional;

public interface GetAgendamentoConsulta {
    Optional<List<AgendamentoConsultaResponseDTO>> execute(Integer idUser);
}
