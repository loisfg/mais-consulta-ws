package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Paciente;
import com.bandtec.mais.consulta.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByCpfAndPassword (String cpf, String senha);

    boolean existsByCpf(String cpf);

    @Query("SELECT p.usuario FROM Paciente p WHERE p.idPaciente = :id")
    Optional<Usuario> findUsuarioPaciente(@Param("id") Integer idPaciente);

}