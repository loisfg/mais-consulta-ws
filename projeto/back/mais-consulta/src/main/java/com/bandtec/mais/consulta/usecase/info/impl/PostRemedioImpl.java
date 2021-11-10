package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.PacienteHasRemedios;
import com.bandtec.mais.consulta.domain.PacienteHasRemediosKey;
import com.bandtec.mais.consulta.gateway.repository.PacienteHasRemediosRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.gateway.repository.RemedioRepository;
import com.bandtec.mais.consulta.usecase.info.PostRemedio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class PostRemedioImpl implements PostRemedio {

    @Autowired
    private RemedioRepository remedioRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteHasRemediosRepository pacienteHasRemediosRepository;

    @Override
    public Optional<PacienteHasRemedios> execute(Iterable<Integer> remedios, Integer pacienteId) {
        if (pacienteRepository.existsById(pacienteId)) {
            for (Integer remedioId : remedios) {
                PacienteHasRemediosKey fk = PacienteHasRemediosKey
                        .builder()
                        .remedioId(remedioId)
                        .pacienteId(pacienteId)
                        .build();

                PacienteHasRemedios pacienteHasRemedios = PacienteHasRemedios
                        .builder()
                        .id(fk)
                        .build();

                pacienteHasRemediosRepository.save(pacienteHasRemedios);

                return Optional.of(pacienteHasRemedios);
            }
        }

        return Optional.empty();
    }
}
