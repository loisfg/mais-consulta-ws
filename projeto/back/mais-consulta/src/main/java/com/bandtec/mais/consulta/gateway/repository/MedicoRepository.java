package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    boolean existsByNome(String nome);

    List<Medico> findByNome(String nome);
}
