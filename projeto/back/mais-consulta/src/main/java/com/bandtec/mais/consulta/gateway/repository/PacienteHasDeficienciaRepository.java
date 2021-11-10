package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.PacienteHasDeficiencia;
import com.bandtec.mais.consulta.domain.PacienteHasDeficienciaKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteHasDeficienciaRepository extends JpaRepository<PacienteHasDeficiencia, PacienteHasDeficienciaKey> {
}
