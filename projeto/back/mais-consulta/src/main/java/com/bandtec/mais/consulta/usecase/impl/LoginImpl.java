package com.bandtec.mais.consulta.usecase.impl;

import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.gateway.database.repository.UsuarioRepository;
import com.bandtec.mais.consulta.models.dto.request.UsuarioRequestDTO;
import com.bandtec.mais.consulta.usecase.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginImpl implements Login {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Optional<Usuario> execute(UsuarioRequestDTO usuarioRequestDTO, List<Usuario> usuariosLogados) {

        Optional<Usuario> oUsuario = usuarioRepository
                .findByCpfAndPassword(usuarioRequestDTO.getCpf(), usuarioRequestDTO.getPassword());

        if(oUsuario.isPresent()) {
            Usuario usuario = oUsuario.get();
            usuariosLogados.add(usuario);
            return oUsuario;
        }
        return oUsuario;

    }
}
