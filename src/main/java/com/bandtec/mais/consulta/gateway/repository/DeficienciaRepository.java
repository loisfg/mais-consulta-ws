package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Deficiency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DeficienciaRepository extends JpaRepository<Deficiency, Integer> {
    @Query("SELECT d.deficiencia FROM PacienteHasDeficiencia d WHERE d.paciente.idPaciente = :id")
    List<Deficiency> findByPacienteId(@Param("id") Integer id);

    Optional<Set<Deficiency>> findByNomeStartingWithIgnoreCase(String nome);
}
