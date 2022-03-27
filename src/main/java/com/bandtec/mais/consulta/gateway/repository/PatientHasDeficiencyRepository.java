package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.PatientHasDeficiency;
import com.bandtec.mais.consulta.domain.PatientHasDeficiencyKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface PatientHasDeficiencyRepository extends JpaRepository<PatientHasDeficiency, PatientHasDeficiencyKey> {
    @Query("SELECT d.paciente.alergias FROM PacienteHasDeficiencia d WHERE d.paciente.idPaciente = :id")
    Set<PatientHasDeficiency> findMedicineByPatientId(@Param("id") Integer id);

}
