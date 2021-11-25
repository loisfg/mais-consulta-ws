package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Exame;
import com.bandtec.mais.consulta.models.dto.response.AgendamentoExameResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ExameRepository  extends JpaRepository<Exame, Integer> {

    @Query(value = "SELECT * " +
            "FROM agendamento a " +
            "INNER JOIN exame e " +
            "WHERE a.paciente_id = :id " +
            "AND a.dt_atendimento BETWEEN :startDate " +
            "AND :dtEnd", nativeQuery = true)
    List<Exame> findAllByPublicationTimeBetween(@Param("id") Integer id,
                                                @Param("startDate") LocalDate dt_start,
                                                @Param("dtEnd") LocalDate dt_end);

    @Query(value = "SELECT new com.bandtec.mais.consulta.models.dto.response.AgendamentoExameResponseDTO(e.descricao, e.agendamento.dtAtendimento, e.agendamento.hrAtendimento, e.agendamento.especialidade.descricao) FROM Exame e WHERE e.agendamento.paciente.idPaciente = :id")
    Optional<List<AgendamentoExameResponseDTO>> findAllExamesByIdUser(@Param("id") Integer idUser);
}
