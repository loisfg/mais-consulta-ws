package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.PacienteHasAlergia;
import com.bandtec.mais.consulta.domain.PacienteHasDeficiencia;
import com.bandtec.mais.consulta.domain.PacienteHasDeficienciaKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface PacienteHasDeficienciaRepository extends JpaRepository<PacienteHasDeficiencia, PacienteHasDeficienciaKey> {
    @Query("SELECT d.paciente.alergias FROM PacienteHasDeficiencia d WHERE d.paciente.idPaciente = :id")
    Set<PacienteHasDeficiencia> findRemedioByIdPaciente(@Param("id") Integer id);

}
