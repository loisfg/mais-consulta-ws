package com.bandtec.mais.consulta.usecase.patient.impl;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.gateway.repository.*;
import com.bandtec.mais.consulta.models.dto.PersonalDataDTO;
import com.bandtec.mais.consulta.models.dto.response.PatientInfoResponseDTO;
import com.bandtec.mais.consulta.usecase.patient.GetPatientInfo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class GetPatientInfoImpl implements GetPatientInfo {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Optional<PatientInfoResponseDTO> execute(Integer patientId) {

        if (patientRepository.existsByPatientId(patientId)) {

            PersonalDataDTO personalDataDTO = getPatient(patientId);

            PatientInfoResponseDTO patientInfoResponseDTO = PatientInfoResponseDTO
                    .builder()
                    .personalData(personalDataDTO)
                    .build();

            return Optional.of(patientInfoResponseDTO);
        }

        return Optional.empty();
    }

    @Override
    public Optional<PersonalDataDTO> run(Integer patientId) {
        if (patientRepository.existsByPatientId(patientId)) {

            PersonalDataDTO personalDataDTO = getPatient(patientId);

            return Optional.of(personalDataDTO);
        }

        return Optional.empty();
    }

    private PersonalDataDTO getPatient(Integer patientId) {
        Patient patient = patientRepository.findById(patientId).get();

        User user = patient.getUser();

        return PersonalDataDTO
                .builder()
                .name(patient.getName())
                .age(calculateAge(patient.getBirthDate()))
                .susNumber(patient.getNumberWallet())
                .cpf(user.getCpf())
                .phone(patient.getPhone())
                .cellPhone(patient.getPhone())
                .email(user.getEmail())
                .build();
    }

    @SneakyThrows
    public static int calculateAge(final LocalDate birthday) {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

}
