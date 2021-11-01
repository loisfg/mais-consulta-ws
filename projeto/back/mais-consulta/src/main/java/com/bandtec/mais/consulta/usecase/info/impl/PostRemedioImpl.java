package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Remedio;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.gateway.repository.RemedioRepository;
import com.bandtec.mais.consulta.usecase.info.PostRemedio;
import com.bandtec.mais.consulta.utils.StrFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostRemedioImpl implements PostRemedio {

    @Autowired
    private RemedioRepository remedioRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Set<Remedio> execute(Set<Remedio> remedio, Integer id) {
        if (pacienteRepository.existsById(id)) {
            if (remedio.isEmpty()) {
                return Set.of();
            }

            // Separando objetos em branco
            Set<Remedio> remedios = remedio
                    .stream()
                    .filter(it -> !Objects.equals(it.getNome(), ""))
                    .collect(Collectors.toSet());


            remedios.forEach(it -> {
                // Evitando dados null no banco
                if (it.getControlado() == null) {
                    it.setControlado(false);
                }

                // Alterando formatação de nome
                it.setNome(StrFormat.toTitledCase(it.getNome()));
            });

            // Atribuindo paciente ao hash
            remedios.stream()
                    .distinct()
                    .iterator()
                    .forEachRemaining(
                            it -> it.setPaciente(
                                    pacienteRepository.getById(id)
                            )
                    );

            remedioRepository.saveAll(remedios);

            return remedios;
        }

        return Set.of();
    }
}
