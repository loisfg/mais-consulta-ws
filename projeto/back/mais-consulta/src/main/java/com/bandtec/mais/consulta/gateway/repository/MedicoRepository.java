package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
}
