package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClinicRepository extends JpaRepository<Clinic, Integer> {
    Optional<Clinic> findClinicByName(String name);

    boolean existsByName(String name);

    @Query("SELECT DISTINCT m.clinic FROM Doctor m WHERE m.specialty.specialtyId = ?1")
    List<Clinic> findClinicBySpecialty(Integer specialtyId);

    @Query("SELECT c FROM Clinic c, Paciente p WHERE c.address.state = p.address.state AND p.patientId = :patientId")
    Optional<List<Clinic>> findClinicByPatientId(@Param("patientId") Integer patientId);

    @Query("SELECT c FROM Clinic c, Paciente p WHERE c.address.district = p.address.district AND c.address.district = :district")
    List<Clinic> findClinicByDistrict(@Param("district") String district);
}
