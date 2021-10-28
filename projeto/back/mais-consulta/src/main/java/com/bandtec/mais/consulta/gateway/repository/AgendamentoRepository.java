package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;
import java.util.Optional;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
    Optional<Agendamento> findByIdAgendamento(Integer idAgendamento);
}