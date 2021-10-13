package com.bandtec.mais.consulta.gateway.database.repository;

import com.bandtec.mais.consulta.domain.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
    Optional<Agendamento> findByUsuarioAndIdAgendamento(Integer idUser, Integer idAgendamento);
}