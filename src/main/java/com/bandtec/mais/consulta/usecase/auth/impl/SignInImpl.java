package com.bandtec.mais.consulta.usecase.auth.impl;

import com.bandtec.mais.consulta.domain.Doctor;
import com.bandtec.mais.consulta.domain.Patient;
import com.bandtec.mais.consulta.domain.User;
import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.gateway.repository.UsuarioRepository;
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
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public Optional<?> execute(SignInUserRequestDTO signInUserRequestDTO, List<User> usuariosLogados) {
        if (usuarioRepository.existsByCpf(signInUserRequestDTO.getCpf())) {
            User user = usuarioRepository
                    .findByCpfAndPassword(signInUserRequestDTO.getCpf(), signInUserRequestDTO.getPassword()).get();

            usuariosLogados.add(user);

            if (user.getRole().equals("Medico")) {
                log.info("USUARIO É UM MEDICO");
                Doctor doctor = medicoRepository.findByUsuario(user).get();

                SignInDoctorResponseDTO signInDoctorResponseDTO = SignInDoctorResponseDTO
                        .builder()
                        .id(doctor.getDoctorId())
                        .name(doctor.getName())
                        .role(user.getRole())
                        .build();

                return Optional.of(signInDoctorResponseDTO);
            }
            else {
                log.info("USUARIO É UM PACIENTE");
                Patient patient = pacienteRepository.findByUsuario(user).get();

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
