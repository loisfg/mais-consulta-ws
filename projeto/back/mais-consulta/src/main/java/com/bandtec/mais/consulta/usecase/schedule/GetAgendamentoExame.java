package com.bandtec.mais.consulta.usecase.schedule;

import com.bandtec.mais.consulta.models.dto.response.interfaces.AgendamentoExameResponse;

import java.util.List;
import java.util.Optional;

public interface GetAgendamentoExame {
    Optional<List<AgendamentoExameResponse>> execute(Integer idUser);
}
