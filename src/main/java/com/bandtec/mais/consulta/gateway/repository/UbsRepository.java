package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Ubs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UbsRepository extends JpaRepository<Ubs, Integer> {
    Optional<Ubs> findUbsByNome(String nome);

    boolean existsByNome(String nome);

    @Query("SELECT DISTINCT m.ubs FROM Medico m WHERE m.especialidade.idEspecialidade = ?1")
    List<Ubs> findUbsByEspecialidade(Integer idEspecialidade);

    @Query("SELECT u FROM Ubs u, Paciente p WHERE u.endereco.estado = p.endereco.estado AND p.idPaciente = :id")
    Optional<List<Ubs>> findUbsByPacienteId(@Param("id") Integer idPaciente);
}
