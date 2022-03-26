package com.bandtec.mais.consulta.usecase.doctor.impl;

import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.models.dto.response.DoctorSchedulingDTO;
import com.bandtec.mais.consulta.usecase.doctor.MedicoAgendamentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoAgendamentosImpl implements MedicoAgendamentos {

    @Autowired
    MedicoRepository medicoRepository;

    @Override
    public Optional<List<DoctorSchedulingDTO>> execute(Integer idMedico) {
        return medicoRepository.findAllAgendamentosByIdMedico(idMedico, LocalDate.now());
    }
}
