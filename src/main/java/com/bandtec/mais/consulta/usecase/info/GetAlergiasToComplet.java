package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Allergy;

import java.util.Optional;
import java.util.Set;

public interface GetAlergiasToComplet {
    Optional<Set<Allergy>> execute(String nome);
}
