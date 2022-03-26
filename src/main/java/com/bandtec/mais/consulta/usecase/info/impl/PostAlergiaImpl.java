package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Allergy;
import com.bandtec.mais.consulta.domain.Patient;
import com.bandtec.mais.consulta.domain.PatientHasAllergy;
import com.bandtec.mais.consulta.domain.PatientHasAllergyKey;
import com.bandtec.mais.consulta.gateway.repository.AlergiaRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteHasAlergiaRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.usecase.info.PostAlergia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PostAlergiaImpl implements PostAlergia {

    @Autowired
    private AlergiaRepository alergiaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    PacienteHasAlergiaRepository pacienteHasAlergiaRepository;

    @Override
    public List<Allergy> execute(Iterable<Integer> alergias, Integer idPaciente) {
        Set<PatientHasAllergy> patientHasAlergiasSet = new HashSet<>();
        if (pacienteRepository.existsById(idPaciente)) {
            for (Integer alergiaId : alergias) {
                PatientHasAllergyKey fk = PatientHasAllergyKey
                        .builder()
                        .allergyId(alergiaId)
                        .patientId(idPaciente)
                        .build();

                PatientHasAllergy patientHasAllergy = PatientHasAllergy
                        .builder()
                        .patientHasAllergyId(fk)
                        .build();

                patientHasAlergiasSet.add(patientHasAllergy);
            }

            Patient patient = Patient
                    .builder()
                    .patientId(idPaciente)
                    .allergies(patientHasAlergiasSet)
                    .build();

            pacienteRepository.save(patient);
            pacienteHasAlergiaRepository.saveAll(patientHasAlergiasSet);
        }

        return alergiaRepository.findAllById(alergias);
    }
}
