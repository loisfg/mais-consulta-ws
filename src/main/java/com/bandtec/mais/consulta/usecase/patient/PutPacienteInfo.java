package com.bandtec.mais.consulta.usecase.patient;

import com.bandtec.mais.consulta.domain.Patient;
import com.bandtec.mais.consulta.models.dto.request.PatientInfoPutRequestDTO;

import java.util.Optional;

public interface PutPacienteInfo {
    Optional<Patient> execute(Integer idPaciente, PatientInfoPutRequestDTO pacienteInfoResponseDTO);
}
