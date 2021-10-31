package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Doenca;
import com.bandtec.mais.consulta.gateway.repository.DoencaRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.usecase.info.PostDoenca;
import com.bandtec.mais.consulta.utils.StrFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PostDoencaImpl implements PostDoenca {

    @Autowired
    private DoencaRepository doencaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Set<Doenca> execute(Set<Doenca> doenca, Integer id) {
        if (pacienteRepository.existsById(id)) {
            if (doenca.isEmpty()) {
                return Set.of();
            }

            doenca.stream()
                    .distinct()
                    .iterator()
                    .forEachRemaining(
                            alergias -> alergias.setPaciente(
                                    pacienteRepository.findById(id).get()
                            )
                    );

            doenca.forEach(
                    doencaName -> doencaName.setNome(StrFormat.toTitledCase(doencaName.getNome()))
            );

            doencaRepository.saveAll(doenca);
        }
        return doenca;
    }
}
