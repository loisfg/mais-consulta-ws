package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Doenca;

import java.util.List;

public interface PostDoenca {
    List<Doenca> execute(Iterable<Integer> doencasId, Integer idPaciente);
}
