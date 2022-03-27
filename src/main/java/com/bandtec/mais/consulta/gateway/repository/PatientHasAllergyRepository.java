package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface PatientHasAllergyRepository extends JpaRepository<PatientHasAllergy, PatientHasAllergyKey> {
    @Query("SELECT a.paciente.alergias FROM PacienteHasAlergia a WHERE a.paciente.idPaciente = :id")
    Set<PatientHasAllergy> findMedicineByPatientId(@Param("id") Integer id);
}