package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Paciente;
import com.bandtec.mais.consulta.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PacienteRepository extends CrudRepository<Paciente, Integer> {

    Optional<Paciente> findByUsuario(Usuario usuario);

}
