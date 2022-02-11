package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.gateway.repository.DoencaRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteHasDoencasRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.usecase.info.PostDoenca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PostDoencaImpl implements PostDoenca {

    @Autowired
    PacienteHasDoencasRepository pacienteHasDoencaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private DoencaRepository doencaRepository;

    @Override
    public List<Doenca> execute(Iterable<Integer> doencas, Integer idPaciente) {
        Set<PacienteHasDoencas> pacienteHasRemediosSet = new HashSet<>();
        if (pacienteRepository.existsById(idPaciente)) {
            for (Integer alergiaId : doencas) {
                PacienteHasDoencasKey fk = PacienteHasDoencasKey
                        .builder()
                        .doencaId(alergiaId)
                        .pacienteId(idPaciente)
                        .build();

                PacienteHasDoencas pacienteHasDoencas = PacienteHasDoencas
                        .builder()
                        .id(fk)
                        .build();

                pacienteHasRemediosSet.add(pacienteHasDoencas);
            }

            Paciente paciente = Paciente
                    .builder()
                    .idPaciente(idPaciente)
                    .doencas(pacienteHasRemediosSet)
                    .build();

            pacienteRepository.save(paciente);
            pacienteHasDoencaRepository.saveAll(pacienteHasRemediosSet);
        }

        return doencaRepository.findByPacienteId(idPaciente);
    }
}