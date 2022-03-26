package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.PatientHasActivity;
import com.bandtec.mais.consulta.domain.PatientHasActivityKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface PacienteHasAtividadeRepository extends JpaRepository<PatientHasActivity, PatientHasActivityKey> {

    @Query("SELECT a.paciente.alergias FROM PacienteHasAtividade a WHERE a.paciente.idPaciente = :id")
    Set<PatientHasActivity> findRemedioByIdPaciente(@Param("id") Integer id);
}