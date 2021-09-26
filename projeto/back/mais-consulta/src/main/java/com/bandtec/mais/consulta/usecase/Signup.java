package com.bandtec.mais.consulta.usecase;

import com.bandtec.mais.consulta.domain.Usuario;

import java.util.Optional;

public interface Signup {
    Optional<Usuario> execute(Usuario usuario);
}
