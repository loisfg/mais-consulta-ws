package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Deficiencia;
import com.bandtec.mais.consulta.domain.PacienteHasAlergia;
import com.bandtec.mais.consulta.domain.PacienteHasDeficiencia;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PostDeficiencia {
    List<Deficiencia> execute(Iterable<Integer> deficiencia, Integer idPaciente);
}
