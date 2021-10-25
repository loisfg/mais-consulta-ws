package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Exame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExameRepository  extends JpaRepository<Exame, Integer> {
}
