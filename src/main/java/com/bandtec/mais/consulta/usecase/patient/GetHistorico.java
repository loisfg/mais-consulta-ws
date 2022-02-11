package com.bandtec.mais.consulta.usecase.patient;

import com.bandtec.mais.consulta.models.dto.response.PacienteHistoricoResponseDTO;

import java.util.List;
import java.util.Optional;

public interface GetHistorico {
    Optional<List<PacienteHistoricoResponseDTO>> execute(Integer idPaciente);
}
