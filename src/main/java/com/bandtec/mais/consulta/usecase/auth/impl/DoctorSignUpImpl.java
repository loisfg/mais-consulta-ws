package com.bandtec.mais.consulta.usecase.auth.impl;

import com.bandtec.mais.consulta.domain.Doctor;
import com.bandtec.mais.consulta.domain.Clinic;
import com.bandtec.mais.consulta.domain.User;
import com.bandtec.mais.consulta.gateway.repository.SpecialtyRepository;
import com.bandtec.mais.consulta.gateway.repository.DoctorRepository;
import com.bandtec.mais.consulta.gateway.repository.ClinicRepository;
import com.bandtec.mais.consulta.gateway.repository.UserRepository;
import com.bandtec.mais.consulta.models.dto.request.SignUpDoctorRequestDTO;
import com.bandtec.mais.consulta.usecase.auth.DoctorSignUp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DoctorSignUpImpl implements DoctorSignUp {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Autowired
    private ClinicRepository clinicRepository;

    @Override
    public Optional<User> execute(SignUpDoctorRequestDTO signUpDoctorRequestDTO) {
        Doctor doctor = signUpDoctorRequestDTO.getDoctor();
        User user = SignUpDoctorRequestDTO.convertFromController(signUpDoctorRequestDTO);
        Optional<Clinic> clinic = clinicRepository.findById(signUpDoctorRequestDTO.getClinicId());

        if (userRepository.existsByCpf(user.getCpf())) {
            log.info("User already exist");
            return Optional.empty();
        } else {
            if (specialtyRepository.existsByDescription(doctor.getSpecialty().getDescription())) {
                doctor.setSpecialty(specialtyRepository.findByDescription(doctor.getSpecialty().getDescription()));
            }
            clinic.ifPresent(doctor::setClinic);
            doctor.setUser(user);
            doctorRepository.save(doctor);

            return Optional.of(userRepository.save(user));
        }
    }

}
