package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
}