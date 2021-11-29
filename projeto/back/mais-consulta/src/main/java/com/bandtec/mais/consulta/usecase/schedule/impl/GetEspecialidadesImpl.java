package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.gateway.repository.EspecialidadeRepository;
import com.bandtec.mais.consulta.models.dto.response.EspecialidadeResponseDTO;
import com.bandtec.mais.consulta.usecase.schedule.GetEspecialidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class GetEspecialidadesImpl implements GetEspecialidades {

    @Autowired
    EspecialidadeRepository especialidadeRepository;

    @Override
    public Optional<Set<EspecialidadeResponseDTO>> execute() {
        return especialidadeRepository.findAllEspecialidades();
    }
}
