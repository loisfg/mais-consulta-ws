package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Deficiencia;
import com.bandtec.mais.consulta.gateway.repository.DeficienciaRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.usecase.info.PostDeficiencia;
import com.bandtec.mais.consulta.utils.StrFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PostDeficienciaImpl implements PostDeficiencia {

    @Autowired
    private DeficienciaRepository deficienciaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Set<Deficiencia> execute(Set<Deficiencia> deficiencia, Integer id) {
        if (pacienteRepository.existsById(id)) {
            if (deficiencia.isEmpty()) {
                return Set.of();
            }

            deficiencia.stream()
                    .distinct()
                    .iterator()
                    .forEachRemaining(
                            deficiencias -> deficiencias.setPaciente(
                                    pacienteRepository.findById(id).get()
                            )
                    );

            deficiencia.forEach(
                    deficienciaName -> deficienciaName.setNome(
                            StrFormat.toTitledCase(deficienciaName.getNome())
                    )
            );

            deficienciaRepository.saveAll(deficiencia);
        }

        return deficiencia;
    }
}
