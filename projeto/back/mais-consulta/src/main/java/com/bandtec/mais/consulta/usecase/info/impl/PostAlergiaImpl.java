package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Alergia;
import com.bandtec.mais.consulta.domain.Paciente;
import com.bandtec.mais.consulta.gateway.repository.AlergiaRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.usecase.info.PostAlergia;
import com.bandtec.mais.consulta.utils.StrFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PostAlergiaImpl implements PostAlergia {

    @Autowired
    private AlergiaRepository alergiaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Set<Alergia> execute(Set<Alergia> alergia, Integer id) {
        if (pacienteRepository.existsById(id)) {
            Paciente paciente = pacienteRepository.getById(id);

            //TODO fazer parte de filtragem para não repetir alergias na board
            paciente.getAlergias().stream().filter(
                    alergias -> alergias.equals(alergia)
            );

            if (alergia.isEmpty()) {
                return Set.of();
            }

            alergia.stream()
                    .distinct()
                    .iterator()
                    .forEachRemaining(
                            alergias -> alergias.setPaciente(
                                    pacienteRepository.findById(id).get()
                            )
                    );

            alergia.forEach(
                    alergiaName -> alergiaName.setNome(StrFormat.toTitledCase(alergiaName.getNome()))
            );

            alergiaRepository.saveAll(alergia);
        }

        return alergia;
    }
}
