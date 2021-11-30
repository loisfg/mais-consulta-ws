package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Integer> {
}