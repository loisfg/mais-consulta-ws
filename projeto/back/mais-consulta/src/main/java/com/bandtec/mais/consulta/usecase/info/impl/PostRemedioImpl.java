package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Remedio;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.gateway.repository.RemedioRepository;
import com.bandtec.mais.consulta.usecase.info.PostRemedio;
import com.bandtec.mais.consulta.utils.StrFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

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

            remedio.stream()
                    .distinct()
                    .iterator()
                    .forEachRemaining(
                            alergias -> alergias.setPaciente(
                                    pacienteRepository.findById(id).get()
                            )
                    );

            remedio.forEach(
                    alergiaName -> alergiaName.setNome(StrFormat.toTitledCase(alergiaName.getNome()))
            );

            remedioRepository.saveAll(remedio);
        }

        return remedio;
    }
}
