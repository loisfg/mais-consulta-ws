package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Especialidade;
import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.domain.Ubs;
import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.models.dto.response.MedicoAgendamentoDTO;
import com.bandtec.mais.consulta.models.dto.response.MedicoHistoricoResponseDTO;
import com.bandtec.mais.consulta.models.enums.AgendamentoStatusEnum;
import org.apache.tomcat.jni.Local;
import org.springframework.data.domain.Sort;
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

    //TODO POR DTO AQUI, select tá mto grande
    @Query(value = "SELECT m FROM Medico m WHERE m.especialidade.idEspecialidade = :idEspecialidade AND m.ubs.idUbs= :idUbs")
    Optional<Medico> findMedicosByIdEspecialidadeAndIdUbs(@Param("idEspecialidade") Integer idEspecialidade,
                                                          @Param("idUbs") Integer idUbs);

    @Query(value = "SELECT m.idMedico FROM Medico m WHERE m.especialidade.idEspecialidade = :idEspecialidade AND m.ubs.idUbs= :idUbs")
    Optional<List<Integer>> findIdsMedicosByIdEspecialidadeAndUbs(@Param("idEspecialidade")Integer idEspecialidade,
                                                                  @Param("idUbs")Integer idUbs);

    @Query(value = "SELECT new com.bandtec.mais.consulta.models.dto.response.MedicoAgendamentoDTO(a.paciente.idPaciente, a.idAgendamento, a.paciente.nome,  a.hrAtendimento, a.paciente.dtNascimento) FROM Agendamento a WHERE a.dtAtendimento = :dtAtual AND a.medico.idMedico = :id AND a.status = 'ATIVO'")
    Optional<List<MedicoAgendamentoDTO>> findAllAgendamentosByIdMedico(@Param("id") Integer idMedico,
                                                                       @Param("dtAtual") LocalDate data);

    boolean existsByNome(String nome);

    List<Medico> findByNome(String nome);

    Set<Medico> findAllByEspecialidade(Especialidade especialidade);

    @Query("select m from Medico m")
    List<Medico> findAllMedicos();

    Optional<Medico> findByUsuario(Usuario usuario);

    @Query("SELECT m FROM Medico m WHERE m.ubs.idUbs = :id_ubs")
    List<Medico> findMedicosByUbsId(@Param("id_ubs") Integer idUbs);

    @Query("SELECT a.medico FROM Agendamento a WHERE a.dtAtendimento = :dt_atendimento AND a.hrAtendimento = :hr_atendimento AND a.status <> :status")
    List<Medico> findMedicosByAgendamento(@Param("dt_atendimento") LocalDate dtAtendimento,
                                          @Param("hr_atendimento") LocalTime hrAtendimento,
                                          @Param("status") String status) ;

    boolean existsByIdMedico(Integer idMedico);

    @Query("SELECT DISTINCT new com.bandtec.mais.consulta.models.dto.response.MedicoHistoricoResponseDTO(a.idAgendamento, a.paciente.nome, a.paciente.dtNascimento, a.dtAtendimento) FROM Agendamento a WHERE a.medico.idMedico = :idMedico AND a.status = 'FINALIZADO'")
    Optional<List<MedicoHistoricoResponseDTO>> findHistoricoAgendamentos(@Param("idMedico") Integer idMedico);
}
