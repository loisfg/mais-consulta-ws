package com.bandtec.mais.consulta.usecase.schedule;

import com.bandtec.mais.consulta.models.dto.response.SpecialtyResponseDTO;

import java.util.Optional;
import java.util.Set;

public interface GetSpecialties {
    Optional<Set<SpecialtyResponseDTO>> execute();
}
