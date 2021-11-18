package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Exame;
import com.bandtec.mais.consulta.models.dto.response.interfaces.AgendamentoExameResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ExameRepository  extends JpaRepository<Exame, Integer> {

    /*    @Query(value = "SELECT * " +
            "FROM agendamento a " +
            "INNER JOIN exame e " +
            "WHERE a.paciente_id = :id " +
            "AND a.dt_atendimento BETWEEN = :startDate " +
            "AND :dtEnd", nativeQuery = true)
    List<Exame> findAllByPublicationTimeBetween(@Param("id") Integer id, @Param("startDate") LocalDate dt_start, @Param("dtEnd") LocalDate dt_end);*/

    @Query(value ="SELECT e.descricao AS descricao, a.dt_atendimento AS dtAtendimento," +
            " a.hr_atendimento AS hrAtendimento, es.descricao AS especialidades " +
            "FROM exame e " +
            "INNER JOIN agendamento a " +
            "INNER JOIN especialidade es " +
            "ON e.agendamento_id = a.id_agendamento " +
            "ON a.especialidade_id = es.id_especialidade " +
            "WHERE a.paciente_id = :id", nativeQuery = true)
    Optional<List<AgendamentoExameResponse>> findAllExamesByIdUser(@Param("id") Integer id);
}
