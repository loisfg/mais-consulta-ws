package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Alergia;
import com.bandtec.mais.consulta.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlergiaRepository extends JpaRepository<Alergia, Integer> {
    @Query("SELECT p.alergia FROM PacienteHasAlergia p WHERE p.paciente.idPaciente = :id")
    List<Alergia> findByPacienteId(@Param("id") Integer id);
}
