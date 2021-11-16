package com.bandtec.mais.consulta.usecase.auth.impl;

import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.gateway.repository.UsuarioRepository;
import com.bandtec.mais.consulta.models.dto.request.UsuarioSignInRequestDTO;
import com.bandtec.mais.consulta.models.dto.response.MedicoSignInResponseDTO;
import com.bandtec.mais.consulta.models.dto.response.PacienteSignInResponseDTO;
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
    public Optional<?> execute(UsuarioSignInRequestDTO usuarioSignInRequestDTO, List<Usuario> usuariosLogados) {
        if (usuarioRepository.existsByCpf(usuarioSignInRequestDTO.getCpf())) {
            Usuario usuario = usuarioRepository
                    .findByCpfAndPassword(usuarioSignInRequestDTO.getCpf(), usuarioSignInRequestDTO.getPassword()).get();

            usuariosLogados.add(usuario);

            if (usuario.getRole().equals("MEDICO")) {
                log.info("USUARIO É UM MEDICO");

                MedicoSignInResponseDTO medicoSignInResponseDTO = new MedicoSignInResponseDTO();

                medicoSignInResponseDTO.setCpf(usuario.getCpf());
                medicoSignInResponseDTO.setRole(usuario.getRole());
                medicoSignInResponseDTO.setEmail(usuario.getEmail());

                medicoSignInResponseDTO.setMedico(medicoRepository.findByUsuario(usuario).get());

                return Optional.of(medicoSignInResponseDTO);
            }
            else {
                log.info("USUARIO É UM PACIENTE");

                PacienteSignInResponseDTO pacienteSignInResponseDTO = new PacienteSignInResponseDTO();

                pacienteSignInResponseDTO.setCpf(usuario.getCpf());
                pacienteSignInResponseDTO.setRole(usuario.getRole());
                pacienteSignInResponseDTO.setEmail(usuario.getEmail());

                pacienteSignInResponseDTO.setPaciente(pacienteRepository.findByUsuario(usuario).get());

                return Optional.of(pacienteSignInResponseDTO);
            }
        }
        return Optional.empty();
    }
}
