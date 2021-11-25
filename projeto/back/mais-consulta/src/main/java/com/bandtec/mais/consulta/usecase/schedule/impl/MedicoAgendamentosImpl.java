package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.models.dto.response.MedicoAgendamentoDTO;
import com.bandtec.mais.consulta.usecase.schedule.MedicoAgendamentos;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MedicoAgendamentosImpl implements MedicoAgendamentos {

    @Autowired
    MedicoRepository medicoRepository;

    @Override
    public List<MedicoAgendamentoDTO> execute(Integer idMedico) {
        return medicoRepository.findAllAgendamentosByIdMedico(idMedico, LocalDate.now());
    }
}
