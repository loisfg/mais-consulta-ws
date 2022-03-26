package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Allergy;
import com.bandtec.mais.consulta.gateway.repository.AlergiaRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.usecase.info.GetAlergia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAlergiaImpl implements GetAlergia {

    @Autowired
    private AlergiaRepository alergiaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Allergy> execute(Integer idUser) {
        if(pacienteRepository.existsById(idUser)) {
            return alergiaRepository.findByPacienteId(idUser);
        }

        return List.of();
    }
}
