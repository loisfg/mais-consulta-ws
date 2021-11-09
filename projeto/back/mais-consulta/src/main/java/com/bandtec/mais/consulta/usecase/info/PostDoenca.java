package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Doenca;
import com.bandtec.mais.consulta.domain.PacienteHasDoencas;

import java.util.Optional;
import java.util.Set;

public interface PostDoenca {
    Optional<PacienteHasDoencas> execute(Iterable<Integer> doencasId, Integer idPaciente);
}
