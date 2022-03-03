package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.models.dto.response.HoursResponseDTO;
import com.bandtec.mais.consulta.models.enums.AgendamentoStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

    @Query("SELECT a FROM Agendamento a WHERE a.paciente.idPaciente = :id")
    List<Agendamento> findByAgendamentoByPacienteId(@Param("id") Integer idPaciente);

    Optional<Agendamento> findByIdAgendamento(Integer idAgendamento);

    Optional<Agendamento> findFirstByPaciente_Usuario_IdUsuarioOrderByDtAtendimentoDesc(Integer idUsuario);

    @Query("SELECT a FROM Agendamento a WHERE a.dtAtendimento = :dt_atendimento AND a.hrAtendimento = :hr_atendimento")
    Optional<Agendamento> findByDtAtendimentoAndHrAtendimento(@Param("dt_atendimento") LocalDate dtAtendimento,
                                                              @Param("hr_atendimento") LocalTime hrAtendimento);

    Optional<Agendamento> findAgendamentoByDtAtendimentoAndHrAtendimentoAndStatus(LocalDate dtAtendimento,
                                                                                  LocalTime hrAtendimento,
                                                                                  AgendamentoStatusEnum status);

    @Query("SELECT new com.bandtec.mais.consulta.models.dto.response.HoursResponseDTO(a.dtAtendimento, a.hrAtendimento, a.medico.idMedico) FROM Agendamento a WHERE a.medico.ubs.idUbs = :idUbs AND a.dtAtendimento = :dia")
    List<HoursResponseDTO> findHrAndDtAtendimentoByIdUbs(@Param("idUbs") Integer idUbs,
                                                         @Param("dia") LocalDate dia);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Agendamento a SET a.status = :status WHERE a.idAgendamento = :id_agendamento")
    void updateAgendamentoStatus(@Param("id_agendamento") Integer idAgendamento,
                                 @Param("status") AgendamentoStatusEnum status);

}
