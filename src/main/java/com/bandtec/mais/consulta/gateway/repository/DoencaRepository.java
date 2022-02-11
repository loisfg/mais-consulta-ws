package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.models.dto.response.InfoResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DoencaRepository extends JpaRepository<Doenca,Integer> {
    @Query("SELECT d.doenca FROM PacienteHasDoencas d WHERE d.paciente.idPaciente = :id")
    List<Doenca> findByPacienteId(@Param("id") Integer id);

    @Query("SELECT d FROM PacienteHasDoencas d WHERE d.paciente.idPaciente = :id")
    Set<PacienteHasDoencas> findDoencasByPacienteId(@Param("id") Integer id);

    @Query("SELECT new com.bandtec.mais.consulta.models.dto.response.InfoResponseDTO(d.id, d.nome) FROM Doenca d WHERE d.cronico = true")
    Optional<Set<InfoResponseDTO>> findDoencaByNomeStartingWithIgnoreCaseAndCronico(String nome);

    @Query("SELECT new com.bandtec.mais.consulta.models.dto.response.InfoResponseDTO(d.id, d.nome) FROM Doenca d WHERE d.dst = true")
    Optional<Set<InfoResponseDTO>> findDoencaByNomeStartingWithIgnoreCaseAndDst(String nome);
}
