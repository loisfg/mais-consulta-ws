package com.bandtec.mais.consulta.usecase.auth.impl;

import com.bandtec.mais.consulta.domain.Paciente;
import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.gateway.database.repository.PacienteRepository;
import com.bandtec.mais.consulta.gateway.database.repository.UsuarioRepository;
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
        Usuario usuario = new Usuario();
        Paciente paciente = pacienteSignUpRequestDTO.getPaciente();

        buildNewUsuario(pacienteSignUpRequestDTO, usuario);
        paciente.setUsuario(usuario);

        if (usuarioRepository.existsByCpf(usuario.getCpf())) {
            return Optional.empty();
        } else {
            pacienteRepository.save(paciente);
            return Optional.of(usuarioRepository.save(usuario));
        }
    }

    private void buildNewUsuario(PacienteSignUpRequestDTO pacienteSignUpRequestDTO, Usuario usuario) {
        usuario.setCpf(pacienteSignUpRequestDTO.getCpf());
        usuario.setEmail(pacienteSignUpRequestDTO.getEmail());
        usuario.setPassword(pacienteSignUpRequestDTO.getPassword());
        usuario.setTelefone(pacienteSignUpRequestDTO.getTelefone());
    }
}
