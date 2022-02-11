package com.bandtec.mais.consulta.usecase.patient;

import com.bandtec.mais.consulta.domain.Paciente;
import com.bandtec.mais.consulta.models.dto.request.PacienteInfoPutResquestDTO;

import java.util.Optional;

public interface PutPacienteInfo {
    Optional<Paciente> execute(Integer idPaciente, PacienteInfoPutResquestDTO pacienteInfoResponseDTO);
}
