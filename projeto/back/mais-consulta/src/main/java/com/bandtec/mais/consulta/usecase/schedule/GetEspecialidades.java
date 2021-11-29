package com.bandtec.mais.consulta.usecase.schedule;

import com.bandtec.mais.consulta.models.dto.response.EspecialidadeResponseDTO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface GetEspecialidades {
    Optional<Set<EspecialidadeResponseDTO>> execute();
}
