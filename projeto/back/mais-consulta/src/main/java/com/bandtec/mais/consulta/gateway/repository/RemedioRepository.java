package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RemedioRepository extends JpaRepository<Remedio,Integer> {

    Set<Remedio> findByNomeContainingIgnoreCase(String nome);

}
