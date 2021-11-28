package com.bandtec.mais.consulta.usecase.patient.impl;

import com.bandtec.mais.consulta.domain.Especialidade;
import com.bandtec.mais.consulta.usecase.patient.GetEspecialidadesAgenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetEspecialidadesAgendaImpl implements GetEspecialidadesAgenda {

    @Override
    public List<Especialidade> execute(Integer idPaciente) {
        return null;
    }
}
