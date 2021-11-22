package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Hora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface HoraRepository extends JpaRepository<Hora, Integer> {
    Set<Hora> findAllOrderByHoras();
}