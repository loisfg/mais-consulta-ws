package com.bandtec.mais.consulta.usecase.schedule;

import com.bandtec.mais.consulta.domain.Medico;
import io.swagger.models.auth.In;

import java.util.List;
import java.util.Optional;

public interface GetIdMedicoEspecialidade {
    Optional<List<Integer>> execute(Integer idEspecialidade);
}
