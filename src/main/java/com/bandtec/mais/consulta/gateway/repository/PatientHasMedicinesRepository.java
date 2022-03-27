package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.PatientHasMedicine;
import com.bandtec.mais.consulta.domain.PatientHasMedicinesKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface PatientHasMedicinesRepository extends JpaRepository<PatientHasMedicine, PatientHasMedicinesKey> {
    @Query("SELECT r.paciente.remedios FROM PacienteHasRemedios r WHERE r.paciente.idPaciente = :id")
    Set<PatientHasMedicine> findMedicineByPatientId(@Param("id") Integer id);
}
