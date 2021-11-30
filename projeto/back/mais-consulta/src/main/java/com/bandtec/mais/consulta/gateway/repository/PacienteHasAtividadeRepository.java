package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.PacienteHasAlergia;
import com.bandtec.mais.consulta.domain.PacienteHasAtividade;
import com.bandtec.mais.consulta.domain.PacienteHasAtividadeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface PacienteHasAtividadeRepository extends JpaRepository<PacienteHasAtividade, PacienteHasAtividadeKey> {

    @Query("SELECT a.paciente.alergias FROM PacienteHasAtividade a WHERE a.paciente.idPaciente = :id")
    Set<PacienteHasAtividade> findRemedioByIdPaciente(@Param("id") Integer id);
}