package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Deficiencia;
import com.bandtec.mais.consulta.domain.Paciente;
import com.bandtec.mais.consulta.domain.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface RemedioRepository extends JpaRepository<Remedio, Integer> {

    Set<Remedio> findByNomeStartingWithIgnoreCase(String nome);

    @Query("SELECT r.remedio FROM PacienteHasRemedios r WHERE r.paciente.idPaciente = :id")
    List<Remedio> findByPacienteId(@Param("id") Integer id);
}
