package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.gateway.repository.DoencaRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteHasDoencasRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.usecase.info.PostDoenca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PostDoencaImpl implements PostDoenca {

    @Autowired
    PacienteHasDoencasRepository pacienteHasDoencaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private DoencaRepository doencaRepository;

    @Override
    public List<Disease> execute(Iterable<Integer> doencas, Integer idPaciente) {
        Set<PatientHasDisease> pacienteHasRemediosSet = new HashSet<>();
        if (pacienteRepository.existsById(idPaciente)) {
            for (Integer alergiaId : doencas) {
                PatientHasDiseaseKey fk = PatientHasDiseaseKey
                        .builder()
                        .diseaseId(alergiaId)
                        .patientId(idPaciente)
                        .build();

                PatientHasDisease patientHasDisease = PatientHasDisease
                        .builder()
                        .patientHasDiseasesId(fk)
                        .build();

                pacienteHasRemediosSet.add(patientHasDisease);
            }

            Patient patient = Patient
                    .builder()
                    .patientId(idPaciente)
                    .diseases(pacienteHasRemediosSet)
                    .build();

            pacienteRepository.save(patient);
            pacienteHasDoencaRepository.saveAll(pacienteHasRemediosSet);
        }

        return doencaRepository.findByPacienteId(idPaciente);
    }
}