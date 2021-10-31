package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Integer> {
    boolean existsByDescricao(String descricao);

    Especialidade findByDescricao(String descricao);
}
