package com.bandtec.mais.consulta.usecase.auth.impl;

import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.gateway.database.repository.PacienteRepository;
import com.bandtec.mais.consulta.gateway.database.repository.UsuarioRepository;
import com.bandtec.mais.consulta.models.dto.request.UsuarioSignUpRequestDTO;
import com.bandtec.mais.consulta.usecase.auth.Signup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignupImpl implements Signup {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Optional<Usuario> execute(UsuarioSignUpRequestDTO usuarioSignUpRequestDTO) {

        Usuario usuario = new Usuario();

        usuario.setCpf(usuarioSignUpRequestDTO.getCpf());
        usuario.setEmail(usuarioSignUpRequestDTO.getEmail());
        usuario.setPaciente(usuarioSignUpRequestDTO.getPaciente());
        usuario.setPassword(usuarioSignUpRequestDTO.getPassword());
        usuario.setTelefone(usuarioSignUpRequestDTO.getTelefone());

        if (usuarioRepository.existsByCpf(usuario.getCpf())) {
            return Optional.empty();
        } else {
            pacienteRepository.save(usuario.getPaciente());
            return Optional.of(usuarioRepository.save(usuario));
        }
    }
}
