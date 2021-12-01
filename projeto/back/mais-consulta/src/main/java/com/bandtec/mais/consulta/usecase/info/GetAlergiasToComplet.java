package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Alergia;
import com.bandtec.mais.consulta.domain.Remedio;

import java.util.Optional;
import java.util.Set;

public interface GetAlergiasToComplet {
    Optional<Set<Alergia>> execute(String nome);
}
