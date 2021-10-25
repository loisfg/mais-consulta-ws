package com.bandtec.mais.consulta.usecase.auth.impl;

import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.gateway.repository.UsuarioRepository;
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
        Medico medico = medicoSignUpRequestDTO.getMedico();
        Usuario usuario = MedicoSignUpRequestDTO.convertFromController(medicoSignUpRequestDTO);

        if (usuarioRepository.existsByCpf(usuario.getCpf())) {
            return Optional.empty();
        } else {
            medico.setUsuario(usuario);
            medicoRepository.save(medico);
            return Optional.of(usuarioRepository.save(usuario));
        }
    }

}
