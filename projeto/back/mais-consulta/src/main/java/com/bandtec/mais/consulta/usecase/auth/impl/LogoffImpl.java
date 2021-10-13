package com.bandtec.mais.consulta.usecase.auth.impl;

import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.usecase.auth.Logoff;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogoffImpl implements Logoff {
    @Override
    public Optional<?> execute(Integer idUsuario, List<Usuario> usuariosLogados) {

        return usuariosLogados.stream()
                .filter(it -> it.getIdUsuario().equals(idUsuario))
                .findFirst()
                .map(usuariosLogados::remove);
    }
}
