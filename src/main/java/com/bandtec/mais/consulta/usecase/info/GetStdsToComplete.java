package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.models.dto.response.InfoResponseDTO;

import java.util.Optional;
import java.util.Set;

public interface GetStdsToComplete {
    Optional<Set<InfoResponseDTO>> execute(String name);
}
