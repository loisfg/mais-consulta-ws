package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Specialty;
import com.bandtec.mais.consulta.domain.Doctor;
import com.bandtec.mais.consulta.domain.User;
import com.bandtec.mais.consulta.models.dto.response.DoctorSchedulingDTO;
import com.bandtec.mais.consulta.models.dto.response.DoctorHistoricResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface MedicoRepository extends JpaRepository<Doctor, Integer> {



    @Query(value = "SELECT m.idMedico FROM Medico m WHERE m.especialidade.idEspecialidade = :idEspecialidade AND m.ubs.idUbs=:idUbs")
    List<Integer> findIdsMedicosByIdEspecialidadeAndIdUbs(@Param("idEspecialidade") Integer idEspecialidade,
                                                                    @Param("idUbs") Integer idUbs);

    //TODO POR DTO AQUI, select tá mto grande
    @Query(value = "SELECT m FROM Medico m WHERE m.especialidade.idEspecialidade = :idEspecialidade AND m.ubs.idUbs= :idUbs")
    Optional<Doctor> findMedicosByIdEspecialidadeAndIdUbs(@Param("idEspecialidade") Integer idEspecialidade,
                                                          @Param("idUbs") Integer idUbs);

    @Query(value = "SELECT m.idMedico FROM Medico m WHERE m.especialidade.idEspecialidade = :idEspecialidade AND m.ubs.idUbs= :idUbs")
    Optional<List<Integer>> findIdsMedicosByIdEspecialidadeAndUbs(@Param("idEspecialidade")Integer idEspecialidade,
                                                                  @Param("idUbs")Integer idUbs);

    @Query(value = "SELECT new com.bandtec.mais.consulta.models.dto.response.MedicoAgendamentoDTO(a.paciente.idPaciente, a.idAgendamento, a.paciente.nome,  a.hrAtendimento, a.paciente.dtNascimento) FROM Agendamento a WHERE a.dtAtendimento = :dtAtual AND a.medico.idMedico = :id AND a.status = 'ATIVO'")
    Optional<List<DoctorSchedulingDTO>> findAllAgendamentosByIdMedico(@Param("id") Integer idMedico,
                                                                      @Param("dtAtual") LocalDate data);

    boolean existsByNome(String nome);

    List<Doctor> findByNome(String nome);

    Set<Doctor> findAllByEspecialidade(Specialty specialty);

    @Query("select m from Medico m")
    List<Doctor> findAllMedicos();

    Optional<Doctor> findByUsuario(User user);

    @Query("SELECT m FROM Medico m WHERE m.ubs.idUbs = :id_ubs")
    List<Doctor> findMedicosByUbsId(@Param("id_ubs") Integer idUbs);

    @Query("SELECT a.medico FROM Agendamento a WHERE a.dtAtendimento = :dt_atendimento AND a.hrAtendimento = :hr_atendimento AND a.status <> :status")
    List<Doctor> findMedicosByAgendamento(@Param("dt_atendimento") LocalDate dtAtendimento,
                                          @Param("hr_atendimento") LocalTime hrAtendimento,
                                          @Param("status") String status) ;

    boolean existsByIdMedico(Integer idMedico);

    @Query("SELECT DISTINCT new com.bandtec.mais.consulta.models.dto.response.MedicoHistoricoResponseDTO(a.idAgendamento, a.paciente.nome, a.paciente.dtNascimento, a.dtAtendimento) FROM Agendamento a WHERE a.medico.idMedico = :idMedico AND a.status = 'FINALIZADO'")
    Optional<List<DoctorHistoricResponseDTO>> findHistoricoAgendamentos(@Param("idMedico") Integer idMedico);
}
