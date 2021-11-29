package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Paciente;
import com.bandtec.mais.consulta.domain.PacienteHasRemedios;
import com.bandtec.mais.consulta.domain.PacienteHasRemediosKey;
import com.bandtec.mais.consulta.domain.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface PacienteHasRemediosRepository extends JpaRepository<PacienteHasRemedios, PacienteHasRemediosKey> {
}
