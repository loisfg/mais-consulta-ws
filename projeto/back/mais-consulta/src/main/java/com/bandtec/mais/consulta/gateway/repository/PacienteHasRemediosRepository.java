package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.PacienteHasRemedios;
import com.bandtec.mais.consulta.domain.PacienteHasRemediosKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteHasRemediosRepository extends JpaRepository<PacienteHasRemedios, PacienteHasRemediosKey> {
}
