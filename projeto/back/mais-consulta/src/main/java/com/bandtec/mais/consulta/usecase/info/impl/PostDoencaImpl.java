package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.gateway.repository.DoencaRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteHasAlergiaRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteHasDoencasRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.usecase.info.PostDoenca;
import com.bandtec.mais.consulta.utils.StrFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostDoencaImpl implements PostDoenca {

    @Autowired
    PacienteHasDoencasRepository pacienteHasDoencaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Optional<PacienteHasDoencas> execute(Iterable<Integer> doencas, Integer idPaciente) {
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

                pacienteHasDoencaRepository.save(pacienteHasDoencas);

                return Optional.of(pacienteHasDoencas);
            }
        }

        return Optional.empty();
    }
}