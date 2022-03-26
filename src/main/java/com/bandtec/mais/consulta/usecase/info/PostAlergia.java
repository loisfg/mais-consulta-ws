package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Allergy;

import java.util.List;

public interface PostAlergia {
    List<Allergy> execute(Iterable<Integer> alergiaId, Integer pacienteId);
}
