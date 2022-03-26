package com.bandtec.mais.consulta.usecase.patient;

import com.bandtec.mais.consulta.models.dto.response.PatientInfoResponseDTO;

import java.util.Optional;

public interface GetPacienteInfo {
    Optional<PatientInfoResponseDTO> execute(Integer idPaciente);
}
