package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Alergia;
import com.bandtec.mais.consulta.gateway.repository.AlergiaRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.usecase.info.PostAlergia;
import com.bandtec.mais.consulta.utils.StrFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostAlergiaImpl implements PostAlergia {

    @Autowired
    private AlergiaRepository alergiaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Set<Alergia> execute(Set<Alergia> alergia, Integer id) {
        if (pacienteRepository.existsById(id)) {
            //TODO fazer parte de filtragem para não repetir alergias na board

            // Validando hash vazio
            if (alergia.isEmpty()) {
                return Set.of();
            }

            // Separando objetos em branco
            Set<Alergia> alergias = alergia
                    .stream()
                    .filter(it -> !Objects.equals(it.getNome(), ""))
                    .collect(Collectors.toSet());

            // Atribuindo paciente ao hash
            alergias.stream()
                    .distinct()
                    .iterator()
                    .forEachRemaining(
                            it -> it.setPaciente(
                                    pacienteRepository.getById(id)
                            )
                    );

            // Alterando formatação de nome
            alergias.forEach(
                    it -> it.setNome(
                            StrFormat.toTitledCase(it.getNome())
                    )
            );

            alergiaRepository.saveAll(alergias);

            return alergias;
        }

        return Set.of();
    }
}
