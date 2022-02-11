package com.bandtec.mais.consulta.usecase.doctor.impl;

import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.models.dto.response.MedicoHistoricoResponseDTO;
import com.bandtec.mais.consulta.usecase.doctor.MedicoAgendamentos;
import com.bandtec.mais.consulta.usecase.doctor.MedicoHistorico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoHistoricoImpl implements MedicoHistorico {

    @Autowired
    MedicoRepository medicoRepository;

    @Override
    public Optional<List<MedicoHistoricoResponseDTO>> execute(Integer idMedico) {
        return medicoRepository.findHistoricoAgendamentos(idMedico);
    }
}
