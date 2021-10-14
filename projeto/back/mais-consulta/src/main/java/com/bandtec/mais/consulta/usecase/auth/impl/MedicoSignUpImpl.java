package com.bandtec.mais.consulta.usecase.auth.impl;

import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.gateway.database.repository.MedicoRepository;
import com.bandtec.mais.consulta.gateway.database.repository.UsuarioRepository;
import com.bandtec.mais.consulta.models.dto.request.MedicoSignUpRequestDTO;
import com.bandtec.mais.consulta.usecase.auth.MedicoSignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicoSignUpImpl implements MedicoSignUp {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public Optional<Usuario> execute(MedicoSignUpRequestDTO medicoSignUpRequestDTO) {
        Usuario usuario = new Usuario();
        Medico medico = medicoSignUpRequestDTO.getMedico();

        buildNewUsuario(medicoSignUpRequestDTO, usuario);
        medico.setUsuario(usuario);

        if (usuarioRepository.existsByCpf(usuario.getCpf())) {
            return Optional.empty();
        } else {
            medicoRepository.save(medico);
            return Optional.of(usuarioRepository.save(usuario));
        }
    }

    private void buildNewUsuario(MedicoSignUpRequestDTO medicoSignUpRequestDTO, Usuario usuario) {
        usuario.setTelefone(medicoSignUpRequestDTO.getTelefone());
        usuario.setPassword(medicoSignUpRequestDTO.getPassword());
        usuario.setEmail(medicoSignUpRequestDTO.getEmail());
        usuario.setCpf(medicoSignUpRequestDTO.getCpf());
    }
}
