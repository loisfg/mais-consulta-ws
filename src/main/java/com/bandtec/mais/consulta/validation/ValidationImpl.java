package com.bandtec.mais.consulta.validation;

import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.error.ResourceNotFoundException;
import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidationImpl implements Validation {

    @Autowired
    MedicoRepository medicoRepository;

    @Override
    public void verifyMedicoExists(Integer idMedico) {

        Optional<Medico> medico= medicoRepository.findById(idMedico);
        if (medico.isEmpty()) {
            throw new ResourceNotFoundException("ID doctor:" + idMedico+" NOT FOUND");
        }
    }
}
