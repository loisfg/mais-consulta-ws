package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Deficiency;

import java.util.Optional;

public interface PutDeficiency {
    Optional<Deficiency> execute(Integer id, Deficiency deficiency);
}
