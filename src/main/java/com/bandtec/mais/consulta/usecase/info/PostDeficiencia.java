package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Deficiency;

import java.util.List;

public interface PostDeficiencia {
    List<Deficiency> execute(Iterable<Integer> deficiencia, Integer idPaciente);
}
