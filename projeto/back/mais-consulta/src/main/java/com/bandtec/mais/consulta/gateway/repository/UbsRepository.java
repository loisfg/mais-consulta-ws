package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Ubs;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UbsRepository extends CrudRepository<Ubs, Integer> {
    Optional<Ubs> findUbsByNome(String nome);

    boolean existsByNome(String nome);
}
