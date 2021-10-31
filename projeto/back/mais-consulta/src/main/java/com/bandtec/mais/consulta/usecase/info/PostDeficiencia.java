package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Deficiencia;

import java.util.Set;

public interface PostDeficiencia {
    Set<Deficiencia> execute(Set<Deficiencia> deficiencia, Integer id);
}
