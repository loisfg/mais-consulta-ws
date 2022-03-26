package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Deficiency;

import java.util.Optional;
import java.util.Set;

public interface GetDeficienciaToComplet {
    Optional<Set<Deficiency>> execute(String nome);
}
