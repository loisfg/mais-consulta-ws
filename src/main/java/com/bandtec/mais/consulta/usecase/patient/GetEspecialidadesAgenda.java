package com.bandtec.mais.consulta.usecase.patient;

import com.bandtec.mais.consulta.domain.Specialty;

import java.util.List;

public interface GetEspecialidadesAgenda {
    List<Specialty> execute(Integer idPaciente);
}
