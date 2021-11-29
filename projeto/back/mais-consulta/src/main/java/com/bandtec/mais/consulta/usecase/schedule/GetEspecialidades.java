package com.bandtec.mais.consulta.usecase.schedule;

import com.bandtec.mais.consulta.domain.Especialidade;

import java.util.List;
import java.util.Optional;

public interface GetEspecialidades {
    Optional<List<Especialidade>> execute();
}
