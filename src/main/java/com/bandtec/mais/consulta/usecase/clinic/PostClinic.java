package com.bandtec.mais.consulta.usecase.clinic;

import com.bandtec.mais.consulta.domain.Clinic;
import com.bandtec.mais.consulta.models.dto.request.ClinicPostRequestDTO;

import java.util.Optional;

public interface PostClinic {
    Optional<Clinic> execute(ClinicPostRequestDTO clinicPostRequestDTO);
}
