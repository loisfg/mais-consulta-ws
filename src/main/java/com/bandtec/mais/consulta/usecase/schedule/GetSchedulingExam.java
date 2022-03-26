package com.bandtec.mais.consulta.usecase.schedule;

import com.bandtec.mais.consulta.models.dto.response.SchedulingResponseDTO;

import java.util.List;
import java.util.Optional;

public interface GetSchedulingExam {
    Optional<List<SchedulingResponseDTO>> execute(Integer idUser);
}
