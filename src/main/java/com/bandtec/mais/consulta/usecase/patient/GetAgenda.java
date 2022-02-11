package com.bandtec.mais.consulta.usecase.patient;

import com.bandtec.mais.consulta.models.dto.response.PacienteAgendamentosResponseDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface GetAgenda {
    Optional<List<PacienteAgendamentosResponseDTO>> execute(Integer idPaciente, String dtStart, String dtEnd);
}
