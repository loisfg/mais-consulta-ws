package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RemedioRepository extends JpaRepository<Medicine, Integer> {

    Optional<Set<Medicine>> findByNomeStartingWithIgnoreCase(String nome);

    @Query("SELECT r.remedio FROM PacienteHasRemedios r WHERE r.paciente.idPaciente = :id")
    List<Medicine> findByPacienteId(@Param("id") Integer id);

    @Query("select r from Remedio r where r.id = ?1")
    List<Medicine> findRemedioById(Iterable<Integer> ids);
}
