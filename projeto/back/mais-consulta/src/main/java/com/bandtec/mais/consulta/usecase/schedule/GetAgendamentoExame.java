package com.bandtec.mais.consulta.usecase.schedule;

import com.bandtec.mais.consulta.models.dto.response.AgendamentoExameResponseDTO;

import java.util.List;
import java.util.Optional;

public interface GetAgendamentoExame {
    Optional<List<AgendamentoExameResponseDTO>> execute(Integer idUser);
}
