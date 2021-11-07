package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.PacienteHasAlergia;

import java.util.Optional;

public interface PostAlergia {
    Optional<PacienteHasAlergia> execute(Iterable<Integer> alergiaId, Integer pacienteId);
}
