package com.bandtec.mais.consulta.usecase.doctor;

import com.bandtec.mais.consulta.models.dto.response.MedicoHistoricoResponseDTO;

import java.util.List;
import java.util.Optional;

public interface MedicoHistorico {
    Optional<List<MedicoHistoricoResponseDTO>> execute(Integer idMedico);
}
