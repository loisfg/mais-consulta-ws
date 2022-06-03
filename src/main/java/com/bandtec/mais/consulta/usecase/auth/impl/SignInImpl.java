package com.bandtec.mais.consulta.usecase.auth.impl;

import com.bandtec.mais.consulta.domain.Doctor;
import com.bandtec.mais.consulta.domain.Patient;
import com.bandtec.mais.consulta.domain.User;
import com.bandtec.mais.consulta.gateway.repository.DoctorRepository;
import com.bandtec.mais.consulta.gateway.repository.PatientRepository;
import com.bandtec.mais.consulta.gateway.repository.UserRepository;
import com.bandtec.mais.consulta.models.dto.request.SignInUserRequestDTO;
import com.bandtec.mais.consulta.models.dto.response.SignInDoctorResponseDTO;
import com.bandtec.mais.consulta.models.dto.response.SignInPatientResponseDTO;
import com.bandtec.mais.consulta.usecase.auth.SignIn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SignInImpl implements SignIn {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Optional<?> execute(SignInUserRequestDTO signInUserRequestDTO, List<User> connectedUsers) {
        if (userRepository.existsByCpf(signInUserRequestDTO.getCpf())) {
            User user = userRepository
                    .findByCpfAndPassword(signInUserRequestDTO.getCpf(), signInUserRequestDTO.getPassword()).get();

            connectedUsers.add(user);

            if (user.getRole().equals("Medico")) {
                log.info("User is a doctor");
                Doctor doctor = doctorRepository.findByUser(user).get();

                SignInDoctorResponseDTO signInDoctorResponseDTO = SignInDoctorResponseDTO
                        .builder()
                        .id(doctor.getDoctorId())
                        .name(doctor.getName())
                        .role(user.getRole())
                        .build();

                return Optional.of(signInDoctorResponseDTO);
            } else {
                log.info("User is a patient");
                Patient patient = patientRepository.findByUser(user).get();

                SignInPatientResponseDTO signInPatientResponseDTO = SignInPatientResponseDTO
                        .builder()
                        .id(patient.getPatientId())
                        .name(patient.getName())
                        .role(user.getRole())
                        .build();

                signInPatientResponseDTO.setRole(user.getRole());

                return Optional.of(signInPatientResponseDTO);
            }
        }
        return Optional.empty();
    }
}
