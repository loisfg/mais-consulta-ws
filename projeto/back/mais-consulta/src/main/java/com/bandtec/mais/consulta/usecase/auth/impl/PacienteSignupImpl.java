package com.bandtec.mais.consulta.usecase.auth.impl;

import com.bandtec.mais.consulta.domain.Paciente;
import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.gateway.repository.UsuarioRepository;
import com.bandtec.mais.consulta.models.dto.request.PacienteSignUpRequestDTO;
import com.bandtec.mais.consulta.usecase.auth.PacienteSignup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PacienteSignupImpl implements PacienteSignup {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Optional<Usuario> execute(PacienteSignUpRequestDTO pacienteSignUpRequestDTO) {
        Paciente paciente = pacienteSignUpRequestDTO.getPaciente();
        Usuario usuario = PacienteSignUpRequestDTO.convertFromController(pacienteSignUpRequestDTO);

        if (usuarioRepository.existsByCpf(usuario.getCpf())) {
            return Optional.empty();
        } else {
            paciente.setUsuario(usuario);
            pacienteRepository.save(paciente);
            return Optional.of(usuarioRepository.save(usuario));
        }
    }


}
