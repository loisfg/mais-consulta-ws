package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.PacienteHasDeficiencia;
import com.bandtec.mais.consulta.domain.PacienteHasDeficienciaKey;
import com.bandtec.mais.consulta.gateway.repository.DeficienciaRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteHasDeficienciaRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.usecase.info.PostDeficiencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostDeficienciaImpl implements PostDeficiencia {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteHasDeficienciaRepository pacienteHasDeficienciaRepository;

    @Override
    public Optional<PacienteHasDeficiencia> execute(Iterable<Integer> deficiencias, Integer idPaciente) {
        if (pacienteRepository.existsById(idPaciente)) {
            for (Integer deficienciaId : deficiencias) {
                PacienteHasDeficienciaKey fk = PacienteHasDeficienciaKey
                        .builder()
                        .deficienciaId(deficienciaId)
                        .pacienteId(idPaciente)
                        .build();

                PacienteHasDeficiencia pacienteHasDeficiencia = PacienteHasDeficiencia
                        .builder()
                        .id(fk)
                        .build();

                pacienteHasDeficienciaRepository.save(pacienteHasDeficiencia);

                return Optional.of(pacienteHasDeficiencia);
            }
        }
        return Optional.empty();
    }
}
