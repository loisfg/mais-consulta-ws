package com.bandtec.mais.consulta.usecase.doctor;

import com.bandtec.mais.consulta.models.dto.response.MedicoAgendamentoDTO;

import java.util.List;
import java.util.Optional;

public interface MedicoAgendamentos {
    Optional<List<MedicoAgendamentoDTO>> execute(Integer idMedico);
}
