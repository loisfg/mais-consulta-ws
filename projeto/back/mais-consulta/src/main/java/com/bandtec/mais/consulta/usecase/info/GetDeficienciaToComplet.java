package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Deficiencia;
import com.bandtec.mais.consulta.domain.Remedio;

import java.util.Optional;
import java.util.Set;

public interface GetDeficienciaToComplet {
    Optional<Set<Deficiencia>> execute(String nome);
}
