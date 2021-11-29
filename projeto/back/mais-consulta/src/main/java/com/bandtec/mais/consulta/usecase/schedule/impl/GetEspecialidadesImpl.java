package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.domain.Especialidade;
import com.bandtec.mais.consulta.gateway.repository.EspecialidadeRepository;
import com.bandtec.mais.consulta.usecase.schedule.GetEspecialidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetEspecialidadesImpl implements GetEspecialidades {

    @Autowired
    EspecialidadeRepository especialidadeRepository;

    @Override
    public Optional<List<Especialidade>> execute() {
        return especialidadeRepository.findAllEspecialidades();
    }
}
