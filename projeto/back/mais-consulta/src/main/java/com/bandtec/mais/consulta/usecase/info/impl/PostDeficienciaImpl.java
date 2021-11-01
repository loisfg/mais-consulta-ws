package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Deficiencia;
import com.bandtec.mais.consulta.domain.Doenca;
import com.bandtec.mais.consulta.gateway.repository.DeficienciaRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.usecase.info.PostDeficiencia;
import com.bandtec.mais.consulta.utils.StrFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostDeficienciaImpl implements PostDeficiencia {

    @Autowired
    private DeficienciaRepository deficienciaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Set<Deficiencia> execute(Set<Deficiencia> deficiencia, Integer id) {
        if (pacienteRepository.existsById(id)) {
            // Validando hash vazio
            if (deficiencia.isEmpty()) {
                return Set.of();
            }

            // Separando objetos em branco
            Set<Deficiencia> deficiencias = deficiencia
                    .stream()
                    .filter(it -> !Objects.equals(it.getNome(), ""))
                    .collect(Collectors.toSet());

            // Atribuindo paciente ao hash
            deficiencias.stream()
                    .distinct()
                    .iterator()
                    .forEachRemaining(
                            it -> it.setPaciente(
                                    pacienteRepository.getById(id)
                            )
                    );

            // Alterando formatação de nome
            deficiencias.forEach(
                    it -> it.setNome(
                            StrFormat.toTitledCase(it.getNome())
                    )
            );

            deficienciaRepository.saveAll(deficiencias);

            return deficiencias;
        }

        return Set.of();
    }
}
