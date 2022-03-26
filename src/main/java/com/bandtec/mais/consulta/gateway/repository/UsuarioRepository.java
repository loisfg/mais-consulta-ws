package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<User, Integer> {

    Optional<User> findByCpfAndPassword (String cpf, String senha);

    boolean existsByCpf(String cpf);

    @Query("SELECT p.usuario FROM Paciente p WHERE p.idPaciente = :id")
    Optional<User> findUsuarioPaciente(@Param("id") Integer idPaciente);

}
