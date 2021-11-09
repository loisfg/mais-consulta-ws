package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Alergia;
import com.bandtec.mais.consulta.domain.PacienteHasAlergia;
import com.bandtec.mais.consulta.domain.PacienteHasAlergiaKey;
import com.bandtec.mais.consulta.gateway.repository.AlergiaRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteHasAlergiaRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.usecase.info.PostAlergia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostAlergiaImpl implements PostAlergia {

    @Autowired
    private AlergiaRepository alergiaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    PacienteHasAlergiaRepository pacienteHasAlergiaRepository;

    @Override
    public List<Alergia> execute(Iterable<Integer> alergias, Integer idPaciente) {
        List<Alergia> newAlergias = List.of();
        if (pacienteRepository.existsById(idPaciente)) {
            for (Integer alergiaId : alergias) {
                PacienteHasAlergiaKey fk = PacienteHasAlergiaKey
                        .builder()
                        .alergiaId(alergiaId)
                        .pacienteId(idPaciente)
                        .build();

                PacienteHasAlergia pacienteHasAlergia = PacienteHasAlergia
                        .builder()
                        .id(fk)
                        .build();

                newAlergias = alergiaRepository.findAllById(alergias);

                pacienteHasAlergiaRepository.save(pacienteHasAlergia);

            }
        }

        return newAlergias;
    }
}
