package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Alergia;
import com.bandtec.mais.consulta.domain.PacienteHasAlergia;
import com.bandtec.mais.consulta.domain.PacienteHasAlergiaKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface PacienteHasAlergiaRepository extends JpaRepository<PacienteHasAlergia, PacienteHasAlergiaKey> {
}