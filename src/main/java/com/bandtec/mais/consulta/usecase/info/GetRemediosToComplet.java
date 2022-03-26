package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Medicine;

import java.util.Optional;
import java.util.Set;

public interface GetRemediosToComplet {
    Optional<Set<Medicine>> execute(String nome);
}
