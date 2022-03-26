package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Allergy;

import java.util.Optional;

public interface PutAlergia {
    Optional<Allergy> execute(Integer id, Allergy allergy);
}
