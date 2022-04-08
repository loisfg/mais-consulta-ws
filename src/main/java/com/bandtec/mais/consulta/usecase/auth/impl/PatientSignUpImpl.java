package com.bandtec.mais.consulta.usecase.auth.impl;

import com.bandtec.mais.consulta.domain.Patient;
import com.bandtec.mais.consulta.domain.User;
import com.bandtec.mais.consulta.gateway.repository.AddressRepository;
import com.bandtec.mais.consulta.gateway.repository.PatientRepository;
import com.bandtec.mais.consulta.gateway.repository.UserRepository;
import com.bandtec.mais.consulta.models.dto.request.SignUpPatientRequestDTO;
import com.bandtec.mais.consulta.usecase.auth.PatientSignUp;
import com.bandtec.mais.consulta.utils.StrFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PatientSignUpImpl implements PatientSignUp {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Optional<User> execute(SignUpPatientRequestDTO signUpPatientRequestDTO) {
        Patient patient = signUpPatientRequestDTO.getPatient();
        User user = SignUpPatientRequestDTO.convertFromController(signUpPatientRequestDTO);

        if (userRepository.existsByCpf(user.getCpf())) {
            return Optional.empty();
        } else {
            patient.setName(StrFormat.toTitledCase(patient.getName()));
            patient.setBirthDate(LocalDate.parse(signUpPatientRequestDTO.getBirthDate()));
            patient.setUser(user);
            addressRepository.save(patient.getAddress());
            patientRepository.save(patient);
            return Optional.of(userRepository.save(user));
        }
    }


}
