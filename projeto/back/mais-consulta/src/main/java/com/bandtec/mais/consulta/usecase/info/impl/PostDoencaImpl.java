package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Doenca;
import com.bandtec.mais.consulta.gateway.repository.DoencaRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.usecase.info.PostDoenca;
import com.bandtec.mais.consulta.utils.StrFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostDoencaImpl implements PostDoenca {

    @Autowired
    private DoencaRepository doencaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Set<Doenca> execute(Set<Doenca> doenca, Integer id) {
        if (pacienteRepository.existsById(id)) {
            // Validando hash vazio
            if (doenca.isEmpty()) {
                return Set.of();
            }

            // Separando objetos em branco
            Set<Doenca> doencas = doenca
                    .stream()
                    .filter(it -> !Objects.equals(it.getNome(), ""))
                    .collect(Collectors.toSet());

            doencas.forEach(it -> {
                // Evitando dados null no banco
                if (it.getCronico() == null) it.setCronico(false);
                if (it.getHereditaria() == null) it.setHereditaria(false);

                // Alterando formatação de nome
                it.setNome(StrFormat.toTitledCase(it.getNome()));
            });


            // Atribuindo paciente ao hash
            doencas.stream()
                    .distinct()
                    .iterator()
                    .forEachRemaining(
                            pacienteDoencas -> pacienteDoencas.setPaciente(
                                    pacienteRepository.getById(id)
                            )
                    );

            doencaRepository.saveAll(doencas);

            return doencas;
        }

        return Set.of();
    }
}