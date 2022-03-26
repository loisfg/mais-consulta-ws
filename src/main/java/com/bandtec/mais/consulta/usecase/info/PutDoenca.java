package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Disease;

import java.util.Optional;

public interface PutDoenca {
    Optional<Disease> execute(Integer id, Disease disease);
}
