package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Deficiencia;

import java.util.Optional;

public interface PutDeficiencia {
    Optional<Deficiencia> execute(Integer id, Deficiencia deficiencia);
}
