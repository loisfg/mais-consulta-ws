package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.PacienteHasAlergia;
import com.bandtec.mais.consulta.domain.PacienteHasAlergiaKey;
import com.bandtec.mais.consulta.gateway.repository.AlergiaRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteHasAlergiaRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.usecase.info.PostAlergia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostAlergiaImpl implements PostAlergia {

    @Autowired
    private AlergiaRepository alergiaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    PacienteHasAlergiaRepository pacienteHasAlergiaRepository;

    @Override
    public Optional<PacienteHasAlergia> execute(Iterable<Integer> iterableIds, Integer pacienteId) {
        if (pacienteRepository.existsById(pacienteId)) {
            for (Integer alergiaId : iterableIds) {
                PacienteHasAlergiaKey fk = PacienteHasAlergiaKey
                        .builder()
                        .alergia_id(alergiaId)
                        .paciente_id(pacienteId)
                        .build();

                PacienteHasAlergia pacienteHasAlergia = PacienteHasAlergia
                        .builder()
                        .id(fk)
                        .build();

                pacienteHasAlergiaRepository.save(pacienteHasAlergia);

                return Optional.of(pacienteHasAlergia);
            }
        }

        return Optional.empty();
    }
}
