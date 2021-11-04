package com.bandtec.mais.consulta.usecase.auth.impl;

import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.gateway.repository.UsuarioRepository;
import com.bandtec.mais.consulta.models.dto.request.UsuarioSignInRequestDTO;
import com.bandtec.mais.consulta.models.dto.response.MedicoSignInResponseDTO;
import com.bandtec.mais.consulta.usecase.auth.MedicoSignIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoSignInImpl implements MedicoSignIn {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public Optional<MedicoSignInResponseDTO> execute(UsuarioSignInRequestDTO usuarioSignInRequestDTO, List<Usuario> usuariosLogados) {
        if (usuarioRepository.existsByCpf(usuarioSignInRequestDTO.getCpf())) {
            Usuario usuario = usuarioRepository
                    .findByCpfAndPassword(usuarioSignInRequestDTO.getCpf(), usuarioSignInRequestDTO.getPassword()).get();
            usuariosLogados.add(usuario);

            MedicoSignInResponseDTO medicoSignInResponseDTO = new MedicoSignInResponseDTO();

            medicoSignInResponseDTO.setCpf(usuario.getCpf());
            medicoSignInResponseDTO.setEmail(usuario.getEmail());

            medicoSignInResponseDTO.setMedico(medicoRepository.findByUsuario(usuario).get());

            return Optional.of(medicoSignInResponseDTO);
        }
        return Optional.empty();
    }

}
