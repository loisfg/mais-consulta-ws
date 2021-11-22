package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Agendamento;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

    Optional<Agendamento> findByIdAgendamento(Integer idAgendamento);

    Optional<Agendamento> findByIdAgendamentoAndPaciente_IdPaciente(Integer idAgendamento, Integer idPaciente);

    Optional<Agendamento> findByHrAtendimento(LocalTime hrAtendimento);

    Optional<Agendamento> findByDtAtendimentoAndHrAtendimento(LocalDate dtAtendimento, LocalTime hrAtendimento);
}
