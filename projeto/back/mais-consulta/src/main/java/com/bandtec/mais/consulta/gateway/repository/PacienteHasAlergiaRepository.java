package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Alergia;
import com.bandtec.mais.consulta.domain.PacienteHasAlergia;
import com.bandtec.mais.consulta.domain.PacienteHasAlergiaKey;
import com.sun.xml.bind.v2.schemagen.xmlschema.List;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface PacienteHasAlergiaRepository extends JpaRepository<PacienteHasAlergia, PacienteHasAlergiaKey> {
}