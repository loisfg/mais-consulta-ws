package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Paciente;
import com.bandtec.mais.consulta.domain.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface RemedioRepository extends JpaRepository<Remedio, Integer> {

    Set<Remedio> findByNomeStartingWithIgnoreCase(String nome);

    List<Remedio> findByPaciente(Paciente paciente);
}
