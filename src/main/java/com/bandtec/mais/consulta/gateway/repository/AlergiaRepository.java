package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Alergia;
import com.bandtec.mais.consulta.domain.Paciente;
import com.bandtec.mais.consulta.domain.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AlergiaRepository extends JpaRepository<Alergia, Integer> {
    @Query("SELECT p.alergia FROM PacienteHasAlergia p WHERE p.paciente.idPaciente = :id")
    List<Alergia> findByPacienteId(@Param("id") Integer id);

    @Query("SELECT p.alergias FROM Paciente p WHERE p.idPaciente = :id")
    Set<Alergia> findAlergiasByIdPaciente(@Param("id") Integer idPaciente);

    Optional<Set<Alergia>> findByNomeStartingWithIgnoreCase(String nome);
}
