package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Doenca;

import java.util.Set;

public interface PostDoenca {
    Set<Doenca> execute(Set<Doenca> doenca, Integer id);
}
