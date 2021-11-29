package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Alergia;
import com.bandtec.mais.consulta.domain.PacienteHasAlergia;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PostAlergia {
    List<Alergia> execute(Iterable<Integer> alergiaId, Integer pacienteId);
}
