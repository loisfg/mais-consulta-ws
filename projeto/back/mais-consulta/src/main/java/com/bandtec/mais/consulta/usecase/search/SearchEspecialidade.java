package com.bandtec.mais.consulta.usecase.search;

import com.bandtec.mais.consulta.domain.Medico;

import java.util.Set;

public interface SearchEspecialidade {
    Set<Medico> execute(String especialidade);
}
