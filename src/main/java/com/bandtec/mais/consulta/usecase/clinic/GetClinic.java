package com.bandtec.mais.consulta.usecase.clinic;

import com.bandtec.mais.consulta.domain.Clinic;

import java.util.List;
import java.util.Optional;

public interface GetClinic {
    Optional<List<Clinic>> execute(Integer patientId);
}
