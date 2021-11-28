package com.bandtec.mais.consulta.usecase.patient;

import com.bandtec.mais.consulta.domain.Especialidade;

import java.util.List;

public interface GetEspecialidadesAgenda {
    List<Especialidade> execute(Integer idPaciente);
}
