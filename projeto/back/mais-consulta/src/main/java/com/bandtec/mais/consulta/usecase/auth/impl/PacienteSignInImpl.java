package com.bandtec.mais.consulta.usecase.auth.impl;

import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.gateway.repository.UsuarioRepository;
import com.bandtec.mais.consulta.models.dto.request.UsuarioSignInRequestDTO;
import com.bandtec.mais.consulta.models.dto.response.PacienteSignInResponseDTO;
import com.bandtec.mais.consulta.usecase.auth.PacienteSignIn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PacienteSignInImpl implements PacienteSignIn {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Optional<PacienteSignInResponseDTO> execute(UsuarioSignInRequestDTO usuarioSignInRequestDTO, List<Usuario> usuariosLogados) {
        if (usuarioRepository.existsByCpf(usuarioSignInRequestDTO.getCpf())) {
            Usuario usuario = usuarioRepository
                    .findByCpfAndPassword(usuarioSignInRequestDTO.getCpf(), usuarioSignInRequestDTO.getPassword()).get();

            if (usuario.getRole().equals("MEDICO")){
                log.info("USUARIO É UM MEDICO");
                return Optional.empty();
            }

            usuariosLogados.add(usuario);

            PacienteSignInResponseDTO pacienteSignInResponseDTO = new PacienteSignInResponseDTO();

            pacienteSignInResponseDTO.setCpf(usuario.getCpf());
            pacienteSignInResponseDTO.setEmail(usuario.getEmail());

            pacienteSignInResponseDTO.setPaciente(pacienteRepository.findByUsuario(usuario).get());

            return Optional.of(pacienteSignInResponseDTO);
        }
        return Optional.empty();
    }
}
