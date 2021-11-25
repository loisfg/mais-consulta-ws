package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Paciente;
import com.bandtec.mais.consulta.domain.PacienteHasRemedios;
import com.bandtec.mais.consulta.domain.PacienteHasRemediosKey;
import com.bandtec.mais.consulta.domain.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteHasRemediosRepository extends JpaRepository<PacienteHasRemedios, PacienteHasRemediosKey> {
    List<Remedio> findByPaciente(Paciente paciente);
}
