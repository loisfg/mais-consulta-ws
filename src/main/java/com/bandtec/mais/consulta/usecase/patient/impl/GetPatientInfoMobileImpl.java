package com.bandtec.mais.consulta.usecase.patient.impl;

import com.bandtec.mais.consulta.domain.Address;
import com.bandtec.mais.consulta.domain.Patient;
import com.bandtec.mais.consulta.domain.User;
import com.bandtec.mais.consulta.gateway.repository.PatientRepository;
import com.bandtec.mais.consulta.models.dto.PersonalDataDTO;
import com.bandtec.mais.consulta.usecase.patient.GetPatientInfoMobile;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class GetPatientInfoMobileImpl implements GetPatientInfoMobile {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Optional<PersonalDataDTO> execute(Integer patientId) {

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
                    .susNumber(patient.getNumberWallet())
                    .cpf(user.getCpf())
                    .phone(patient.getPhone())
                    .city(address.getCity())
                    .state(address.getState())
                    .cellPhone(patient.getPhone())
                    .cep(address.getZipCode())
                    .email(user.getEmail())
                    .build();

            return Optional.of(personalDataDTO);
        }

        return Optional.empty();
    }

    @SneakyThrows
    public static int calculateAge(final LocalDate birthday) {
        return Period.between(birthday, LocalDate.now()).getYears();
    }
}
