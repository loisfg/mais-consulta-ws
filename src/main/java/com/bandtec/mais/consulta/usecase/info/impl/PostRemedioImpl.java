package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Paciente;
import com.bandtec.mais.consulta.domain.PacienteHasRemedios;
import com.bandtec.mais.consulta.domain.PacienteHasRemediosKey;
import com.bandtec.mais.consulta.domain.Remedio;
import com.bandtec.mais.consulta.gateway.repository.PacienteHasRemediosRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.gateway.repository.RemedioRepository;
import com.bandtec.mais.consulta.usecase.info.PostRemedio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
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
    public List<Remedio> execute(Iterable<Integer> remedios, Integer idPaciente) {
        Set<PacienteHasRemedios> pacienteHasRemediosSet = new HashSet<>();
        if (pacienteRepository.existsById(idPaciente)) {
            for (Integer remedioId : remedios) {
                PacienteHasRemediosKey fk = PacienteHasRemediosKey
                        .builder()
                        .remedioId(remedioId)
                        .pacienteId(idPaciente)
                        .build();

                PacienteHasRemedios pacienteHasRemedios = PacienteHasRemedios
                        .builder()
                        .id(fk)
                        .build();

                pacienteHasRemediosSet.add(pacienteHasRemedios);
            }

            Paciente paciente = Paciente
                    .builder()
                    .idPaciente(idPaciente)
                    .remedios(pacienteHasRemediosSet)
                    .build();

            pacienteRepository.save(paciente);
            pacienteHasRemediosRepository.saveAll(pacienteHasRemediosSet);

        }

        return remedioRepository.findRemedioById(remedios);
    }
}
