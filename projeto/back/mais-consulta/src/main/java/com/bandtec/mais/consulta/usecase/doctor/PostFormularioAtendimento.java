package com.bandtec.mais.consulta.usecase.doctor;

import com.bandtec.mais.consulta.models.dto.request.PacienteInfoRequestDTO;

import java.util.Optional;

public interface PostFormularioAtendimento {
    Optional<?> execute(Integer idMedico, Integer idPaciente, Integer idAgendamento, PacienteInfoRequestDTO pacienteInfoRequestDTO);
}
