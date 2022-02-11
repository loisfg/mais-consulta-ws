package com.bandtec.mais.consulta.usecase.ubs.impl;

import com.bandtec.mais.consulta.domain.Ubs;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.gateway.repository.UbsRepository;
import com.bandtec.mais.consulta.usecase.ubs.GetUbs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetUbsImpl implements GetUbs {

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    UbsRepository ubsRepository;

    @Override
    public Optional<List<Ubs>> execute(Integer idPaciente) {
        return ubsRepository.findUbsByPacienteId(idPaciente);
    }
}
