package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Alergia;
import com.bandtec.mais.consulta.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlergiaRepository extends JpaRepository<Alergia, Integer> {
    @Query(value =
            "SELECT alergia.id_alergia, alergia.nome " +
                    "FROM alergia AS alergia " +
                    "INNER JOIN paciente_has_alergia AS paciente_alergias " +
                    "WHERE paciente_alergias.alergia_id = alergia.id_alergia " +
                    "AND paciente_alergias.paciente_id = :id",
            nativeQuery = true)
    List<Alergia> findAlergiaByIdPacienteParams(@Param("id") Integer id);

    List<Alergia> findByPaciente(Paciente paciente);
}
