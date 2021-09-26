package com.bandtec.mais.consulta.gateway.database.repository;

import com.bandtec.mais.consulta.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
