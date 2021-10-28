package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MedicoRepository extends CrudRepository<Medico, Integer> {
    boolean existsByNome(String nome);
}
