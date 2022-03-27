package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Allergy;

import java.util.Optional;

public interface PutAllergy {
    Optional<Allergy> execute(Integer id, Allergy allergy);
}
