package com.bandtec.mais.consulta.usecase.auth.impl;

import com.bandtec.mais.consulta.domain.Patient;
import com.bandtec.mais.consulta.domain.User;
import com.bandtec.mais.consulta.gateway.repository.EnderecoRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.gateway.repository.UsuarioRepository;
import com.bandtec.mais.consulta.models.dto.request.SignUpPatientRequestDTO;
import com.bandtec.mais.consulta.usecase.auth.PacienteSignup;
import com.bandtec.mais.consulta.utils.StrFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PacienteSignupImpl implements PacienteSignup {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public Optional<User> execute(SignUpPatientRequestDTO signUpPatientRequestDTO) {
        Patient patient = signUpPatientRequestDTO.getPatient();
        User user = SignUpPatientRequestDTO.convertFromController(signUpPatientRequestDTO);

        if (usuarioRepository.existsByCpf(user.getCpf())) {
            return Optional.empty();
        } else {
            patient.setName(StrFormat.toTitledCase(patient.getName()));
            patient.setBirthDate(LocalDate.parse(signUpPatientRequestDTO.getBirthDate()));
            patient.setUser(user);
            enderecoRepository.save(patient.getAddress());
            pacienteRepository.save(patient);
            return Optional.of(usuarioRepository.save(user));
        }
    }


}
