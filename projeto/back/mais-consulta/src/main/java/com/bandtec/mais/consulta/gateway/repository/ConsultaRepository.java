package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Consulta;
import com.bandtec.mais.consulta.models.dto.response.AgendamentoConsultaResponseDTO;
import com.bandtec.mais.consulta.models.dto.response.AgendamentoExameResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

    @Query(value = "SELECT new com.bandtec.mais.consulta.models.dto.response.AgendamentoConsultaResponseDTO(c.descricao, c.agendamento.dtAtendimento, c.agendamento.hrAtendimento, c.agendamento.especialidade.descricao) FROM Consulta c WHERE c.agendamento.paciente.idPaciente = :id")
    Optional<List<AgendamentoConsultaResponseDTO>> findAllConsultaByIdUser(@Param("id") Integer idUser);

}