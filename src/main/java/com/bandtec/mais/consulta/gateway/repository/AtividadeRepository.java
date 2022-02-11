package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Atividade;
import com.bandtec.mais.consulta.domain.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AtividadeRepository extends JpaRepository<Atividade, Integer> {

    @Query("SELECT a.atividade FROM PacienteHasAtividade a WHERE a.paciente.idPaciente = :id")
    List<Atividade> findByPacienteId(@Param("id") Integer id);
}