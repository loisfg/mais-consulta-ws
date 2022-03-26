package com.bandtec.mais.consulta.usecase.auth.impl;

import com.bandtec.mais.consulta.domain.User;
import com.bandtec.mais.consulta.usecase.auth.Logoff;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogoffImpl implements Logoff {
    @Override
    public Optional<?> execute(Integer idUsuario, List<User> usuariosLogados) {

        return usuariosLogados.stream()
                .filter(it -> it.getUserId().equals(idUsuario))
                .findFirst()
                .map(usuariosLogados::remove);
    }
}
