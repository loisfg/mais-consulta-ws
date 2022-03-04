package com.bandtec.mais.consulta.validation;

import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.domain.Paciente;
import com.bandtec.mais.consulta.error.ResourceNotFoundException;
import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidationImpl implements Validation {

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    MedicoRepository medicoRepository;

    @Override
    public void verifyMedicoExists(Integer idMedico) {

        Optional<Medico> medico = medicoRepository.findById(idMedico);
        if (medico.isEmpty()) {
            throw new ResourceNotFoundException("ID doctor:" + idMedico + " NOT FOUND");
        }
    }

    @Override
    public void verifyPatient(Integer idPatient) {
        Optional<Paciente> patient = pacienteRepository.findById(idPatient);
        if (patient.isEmpty()) {
            throw new ResourceNotFoundException("ID Patient:" + idPatient + " NOT FOUND");
        }
    }
}
