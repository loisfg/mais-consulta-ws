package com.bandtec.mais.consulta.usecase.doctor;

import com.bandtec.mais.consulta.models.dto.request.PatientInfoRequestDTO;

import java.util.Optional;

public interface PostFormularioAtendimento {
    Optional<?> execute(Integer idMedico, Integer idPaciente, Integer idAgendamento, PatientInfoRequestDTO patientInfoRequestDTO);
}
