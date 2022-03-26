package com.bandtec.mais.consulta.usecase.patient.impl;

import com.bandtec.mais.consulta.domain.Specialty;
import com.bandtec.mais.consulta.usecase.patient.GetEspecialidadesAgenda;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetEspecialidadesAgendaImpl implements GetEspecialidadesAgenda {

    @Override
    public List<Specialty> execute(Integer idPaciente) {
        return null;
    }
}
