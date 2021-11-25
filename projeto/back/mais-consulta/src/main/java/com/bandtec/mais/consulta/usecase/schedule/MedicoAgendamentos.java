package com.bandtec.mais.consulta.usecase.schedule;

import com.bandtec.mais.consulta.models.dto.response.MedicoAgendamentoDTO;

import java.util.List;

public interface MedicoAgendamentos {
    List<MedicoAgendamentoDTO> execute(Integer idMedico);
}
