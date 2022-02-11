package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.PacienteHasAlergia;
import com.bandtec.mais.consulta.domain.PacienteHasDoencas;
import com.bandtec.mais.consulta.domain.PacienteHasDoencasKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface PacienteHasDoencasRepository extends JpaRepository<PacienteHasDoencas, PacienteHasDoencasKey> {

    @Query("SELECT d.paciente.alergias FROM PacienteHasDoencas d WHERE d.paciente.idPaciente = :id")
    Set<PacienteHasDoencas> findRemedioByIdPaciente(@Param("id") Integer id);

}
