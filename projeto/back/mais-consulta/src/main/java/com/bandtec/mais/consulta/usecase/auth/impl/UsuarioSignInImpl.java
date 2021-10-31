package com.bandtec.mais.consulta.usecase.auth.impl;

import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.gateway.repository.UsuarioRepository;
import com.bandtec.mais.consulta.models.dto.request.UsuarioSignInRequestDTO;
import com.bandtec.mais.consulta.models.dto.response.UsuarioSignInResponseDTO;
import com.bandtec.mais.consulta.usecase.auth.UsuarioSignIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioSignInImpl implements UsuarioSignIn {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Optional<UsuarioSignInResponseDTO> execute(UsuarioSignInRequestDTO usuarioSignInRequestDTO, List<Usuario> usuariosLogados) {
        if (usuarioRepository.existsByCpf(usuarioSignInRequestDTO.getCpf())) {
            Usuario usuario = usuarioRepository
                    .findByCpfAndPassword(usuarioSignInRequestDTO.getCpf(), usuarioSignInRequestDTO.getPassword()).get();
            usuariosLogados.add(usuario);

            UsuarioSignInResponseDTO usuarioSignInResponseDTO = new UsuarioSignInResponseDTO();

            usuarioSignInResponseDTO.setCpf(usuario.getCpf());
            usuarioSignInResponseDTO.setEmail(usuario.getEmail());

            usuarioSignInResponseDTO.setPaciente(pacienteRepository.findByUsuario(usuario).get());

            return Optional.of(usuarioSignInResponseDTO);
        }
        return Optional.empty();
    }
}
