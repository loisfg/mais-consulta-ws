package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Deficiencia;
import com.bandtec.mais.consulta.domain.Paciente;
import com.bandtec.mais.consulta.domain.PacienteHasDeficiencia;
import com.bandtec.mais.consulta.domain.PacienteHasDeficienciaKey;
import com.bandtec.mais.consulta.gateway.repository.DeficienciaRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteHasDeficienciaRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.usecase.info.PostDeficiencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PostDeficienciaImpl implements PostDeficiencia {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private DeficienciaRepository deficienciaRepository;

    @Autowired
    private PacienteHasDeficienciaRepository pacienteHasDeficienciaRepository;

    @Override
    public List<Deficiencia> execute(Iterable<Integer> deficiencias, Integer idPaciente) {
        Set<PacienteHasDeficiencia> pacienteHasRemediosSet = new HashSet<>();
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

                pacienteHasRemediosSet.add(pacienteHasDeficiencia);
            }

            Paciente paciente = Paciente
                    .builder()
                    .idPaciente(idPaciente)
                    .deficiencias(pacienteHasRemediosSet)
                    .build();

            pacienteRepository.save(paciente);
            pacienteHasDeficienciaRepository.saveAll(pacienteHasRemediosSet);
        }

        return deficienciaRepository.findByPacienteId(idPaciente);
    }
}
