package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.PatientHasDisease;
import com.bandtec.mais.consulta.domain.PatientHasDiseaseKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface PacienteHasDoencasRepository extends JpaRepository<PatientHasDisease, PatientHasDiseaseKey> {

    @Query("SELECT d.paciente.alergias FROM PacienteHasDoencas d WHERE d.paciente.idPaciente = :id")
    Set<PatientHasDisease> findRemedioByIdPaciente(@Param("id") Integer id);

}
