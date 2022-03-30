package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Specialty;
import com.bandtec.mais.consulta.models.dto.response.SpecialtyResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;

public interface SpecialtyRepository extends JpaRepository<Specialty, Integer> {
    boolean existsByDescription(String description);

    Specialty findByDescription(String description);

    Specialty findFirstByDescription(String description);

    @Query("SELECT DISTINCT new com.bandtec.mais.consulta.models.dto.response.SpecialtyResponseDTO(m.specialty.description, m.specialty.specialtyId) FROM Doctor m")
    Optional<Set<SpecialtyResponseDTO>> findAllSpecialties();
}
