package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Alergia;
import com.bandtec.mais.consulta.domain.Deficiencia;
import com.bandtec.mais.consulta.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeficienciaRepository extends JpaRepository<Deficiencia, Integer> {
    @Query(value =
            "SELECT deficiencia.id_deficiencia, deficiencia.nome " +
                    "FROM deficiencia " +
                        "AS deficiencia " +
                    "INNER JOIN paciente_has_deficiencia " +
                        "AS paciente_deficiencia " +
                    "WHERE paciente_deficiencia.deficiencia_id = deficiencia.id_deficiencia " +
                    "AND paciente_deficiencia.paciente_id = :id",
            nativeQuery = true)
    List<Deficiencia> findDeficienciaByIdPacienteParams(@Param("id") Integer id);

    List<Deficiencia> findByPaciente(Paciente paciente);
}
