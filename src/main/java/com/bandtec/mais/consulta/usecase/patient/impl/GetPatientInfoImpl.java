package com.bandtec.mais.consulta.usecase.patient.impl;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.gateway.repository.*;
import com.bandtec.mais.consulta.models.dto.PersonalDataDTO;
import com.bandtec.mais.consulta.models.dto.MedicalChartDTO;
import com.bandtec.mais.consulta.models.dto.response.PatientInfoResponseDTO;
import com.bandtec.mais.consulta.usecase.patient.GetPatientInfo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GetPatientInfoImpl implements GetPatientInfo {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Optional<PatientInfoResponseDTO> execute(Integer patientId) {

        if (patientRepository.existsByPatientId(patientId)) {

            Patient patient = patientRepository.findById(patientId).get();

            User user = patient.getUser();
            Address address = patient.getAddress();

            PersonalDataDTO personalDataDTO = PersonalDataDTO
                    .builder()
                    .name(patient.getName())
                    .age(calculateAge(patient.getBirthDate()))
                    .address(address.getStreet())
                    .publicPlace(address.getPublicPlace())
                    .complement(address.getComplement())
                    .number(address.getNumber())
                    .district(address.getDistrict())
                    .susNumber(patient.getSusNumberWallet())
                    .cpf(user.getCpf())
                    .phone(patient.getPhone())
                    .city(address.getCity())
                    .state(address.getState())
                    .cellPhone(patient.getPhone())
                    .cep(address.getZipCode())
                    .build();

            PatientInfoResponseDTO patientInfoResponseDTO = PatientInfoResponseDTO
                    .builder()
                    .personalData(personalDataDTO)
                    .build();

            return Optional.of(patientInfoResponseDTO);
        }

        return Optional.empty();
    }

    @SneakyThrows
    public static int calculateAge(final LocalDate birthday) {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

}
