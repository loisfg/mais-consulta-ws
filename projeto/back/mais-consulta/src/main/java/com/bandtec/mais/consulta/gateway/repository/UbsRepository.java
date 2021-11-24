package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Ubs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UbsRepository extends JpaRepository<Ubs, Integer> {
    Optional<Ubs> findUbsByNome(String nome);

    boolean existsByNome(String nome);

    @Query("select m.ubs from Medico m where m.especialidade.idEspecialidade = ?1")
    List<Ubs> findUbsByEspecialidade(Integer idEspecialidade);
}
