package com.bandtec.mais.consulta.usecase.patient;

import com.bandtec.mais.consulta.models.dto.response.PacienteInfoResponseDTO;

import java.util.Optional;

public interface GetPacienteInfo {
    Optional<PacienteInfoResponseDTO> execute(Integer idPaciente);
}
