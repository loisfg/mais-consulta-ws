package com.bandtec.mais.consulta.usecase.doctor;

import com.bandtec.mais.consulta.models.dto.response.DoctorHistoricResponseDTO;

import java.util.List;
import java.util.Optional;

public interface MedicoHistorico {
    Optional<List<DoctorHistoricResponseDTO>> execute(Integer idMedico);
    void verify(Integer idmedico);
}
