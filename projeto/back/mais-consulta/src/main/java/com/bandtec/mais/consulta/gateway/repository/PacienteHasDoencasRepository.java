package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.PacienteHasDoencas;
import com.bandtec.mais.consulta.domain.PacienteHasDoencasKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PacienteHasDoencasRepository extends JpaRepository<PacienteHasDoencas, PacienteHasDoencasKey> {
}
