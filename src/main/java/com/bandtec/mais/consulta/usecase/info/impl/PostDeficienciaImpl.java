package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Deficiency;
import com.bandtec.mais.consulta.domain.Patient;
import com.bandtec.mais.consulta.domain.PatientHasDeficiency;
import com.bandtec.mais.consulta.domain.PatientHasDeficiencyKey;
import com.bandtec.mais.consulta.gateway.repository.DeficienciaRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteHasDeficienciaRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.usecase.info.PostDeficiencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PostDeficienciaImpl implements PostDeficiencia {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private DeficienciaRepository deficienciaRepository;

    @Autowired
    private PacienteHasDeficienciaRepository pacienteHasDeficienciaRepository;

    @Override
    public List<Deficiency> execute(Iterable<Integer> deficiencias, Integer idPaciente) {
        Set<PatientHasDeficiency> pacienteHasRemediosSet = new HashSet<>();
        if (pacienteRepository.existsById(idPaciente)) {
            for (Integer deficienciaId : deficiencias) {
                PatientHasDeficiencyKey fk = PatientHasDeficiencyKey
                        .builder()
                        .deficiencyId(deficienciaId)
                        .patientId(idPaciente)
                        .build();

                PatientHasDeficiency patientHasDeficiency = PatientHasDeficiency
                        .builder()
                        .patientHasDeficiencyId(fk)
                        .build();

                pacienteHasRemediosSet.add(patientHasDeficiency);
            }

            Patient patient = Patient
                    .builder()
                    .patientId(idPaciente)
                    .deficiencies(pacienteHasRemediosSet)
                    .build();

            pacienteRepository.save(patient);
            pacienteHasDeficienciaRepository.saveAll(pacienteHasRemediosSet);
        }

        return deficienciaRepository.findByPacienteId(idPaciente);
    }
}
