package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Especialidade;
import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.domain.Ubs;
import com.bandtec.mais.consulta.domain.Usuario;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {

    @Query(value = "SELECT m.idMedico FROM Medico m WHERE m.especialidade.idEspecialidade = :idEspecialidade AND m.ubs.idUbs=:idUbs")
    List<Integer> findIdsMedicosByIdEspecialidadeAndIdUbs(@Param("idEspecialidade") Integer idEspecialidade,
                                                                    @Param("idUbs") Integer idUbs);

    @Query(value = "SELECT m FROM Medico m WHERE m.especialidade.idEspecialidade = :idEspecialidade AND m.ubs.idUbs= :idUbs")
    Optional<Medico> findMedicosByIdEspecialidadeAndIdUbs(@Param("idEspecialidade") Integer idEspecialidade,
                                                          @Param("idUbs") Integer idUbs);

    boolean existsByNome(String nome);

    List<Medico> findByNome(String nome);

    Set<Medico> findAllByEspecialidade(Especialidade especialidade);

    Optional<Medico> findByUsuario(Usuario usuario);

    @Query("select m from Medico m where m.ubs.idUbs = ?1")
    List<Medico> findMedicosByUbsId(Integer idUbs);

    @Query("SELECT a.medico FROM Agendamento a WHERE a.dtAtendimento = :dt_atendimento AND a.hrAtendimento = :hr_atendimento")
    List<Medico> findMedicosByAgendamento(@Param("dt_atendimento") LocalDate dtAtendimento,
                                          @Param("hr_atendimento") LocalTime hrAtendimento) ;


}
