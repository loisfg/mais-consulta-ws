package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AtividadeRepository extends JpaRepository<Activity, Integer> {

    @Query("SELECT a.atividade FROM PacienteHasAtividade a WHERE a.paciente.idPaciente = :id")
    List<Activity> findByPacienteId(@Param("id") Integer id);
}