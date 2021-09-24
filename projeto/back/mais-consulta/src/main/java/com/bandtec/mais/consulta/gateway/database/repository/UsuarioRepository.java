package com.bandtec.mais.consulta.gateway.database.repository;

import com.bandtec.mais.consulta.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByLoginAndPassword (String login, String senha);

}
