package com.bandtec.mais.consulta.usecase.auth.impl;

import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.domain.Paciente;
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

            if (usuario.getRole().equals("Medico")) {
                log.info("USUARIO É UM MEDICO");
                Medico medico = medicoRepository.findByUsuario(usuario).get();

                MedicoSignInResponseDTO medicoSignInResponseDTO = MedicoSignInResponseDTO
                        .builder()
                        .id(medico.getIdMedico())
                        .nome(medico.getNome())
                        .role(usuario.getRole())
                        .build();

                return Optional.of(medicoSignInResponseDTO);
            }
            else {
                log.info("USUARIO É UM PACIENTE");
                Paciente paciente = pacienteRepository.findByUsuario(usuario).get();

                PacienteSignInResponseDTO pacienteSignInResponseDTO = PacienteSignInResponseDTO
                        .builder()
                        .id(paciente.getIdPaciente())
                        .nome(paciente.getNome())
                        .role(usuario.getRole())
                        .build();

                pacienteSignInResponseDTO.setRole(usuario.getRole());

                return Optional.of(pacienteSignInResponseDTO);
            }
        }
        return Optional.empty();
    }
}
