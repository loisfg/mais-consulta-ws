package com.bandtec.mais.consulta.usecase.schedule;

import com.bandtec.mais.consulta.models.dto.response.AgendamentoResponseDTO;

import java.util.List;
import java.util.Optional;

public interface GetAgendamentoExame {
    Optional<List<AgendamentoResponseDTO>> execute(Integer idUser);
}
