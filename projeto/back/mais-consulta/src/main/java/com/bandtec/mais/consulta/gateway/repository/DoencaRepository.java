package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Doenca;
import com.bandtec.mais.consulta.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoencaRepository extends JpaRepository<Doenca,Integer> {
    List<Doenca> findByPaciente(Paciente paciente);
}
