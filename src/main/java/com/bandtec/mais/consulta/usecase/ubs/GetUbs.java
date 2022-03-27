package com.bandtec.mais.consulta.usecase.ubs;

import com.bandtec.mais.consulta.domain.Ubs;

import java.util.List;
import java.util.Optional;

public interface GetUbs {
    Optional<List<Ubs>> execute(Integer patientId);
}
