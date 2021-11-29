package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Alergia;
import com.bandtec.mais.consulta.domain.Doenca;
import com.bandtec.mais.consulta.domain.Paciente;
import com.bandtec.mais.consulta.domain.PacienteHasDoencas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface DoencaRepository extends JpaRepository<Doenca,Integer> {
    @Query("SELECT d.doenca FROM PacienteHasDoencas d WHERE d.paciente.idPaciente = :id")
    List<Doenca> findByPacienteId(@Param("id") Integer id);

    @Query("SELECT d FROM PacienteHasDoencas d WHERE d.paciente.idPaciente = :id")
    Set<PacienteHasDoencas> findDoencasByPacienteId(@Param("id") Integer id);
}
