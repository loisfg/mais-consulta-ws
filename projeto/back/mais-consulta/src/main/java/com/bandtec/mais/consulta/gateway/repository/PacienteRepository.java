package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Paciente;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PacienteRepository extends CrudRepository<Paciente, Integer> {
}
