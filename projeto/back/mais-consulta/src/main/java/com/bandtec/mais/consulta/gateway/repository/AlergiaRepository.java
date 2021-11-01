package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Alergia;
import com.bandtec.mais.consulta.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface AlergiaRepository extends JpaRepository<Alergia, Integer> {
    Set<Alergia> findAllByPaciente(Paciente paciente);
}
