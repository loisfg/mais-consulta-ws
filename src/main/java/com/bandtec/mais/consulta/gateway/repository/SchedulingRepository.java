package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Scheduling;
import com.bandtec.mais.consulta.models.dto.response.HoursResponseDTO;
import com.bandtec.mais.consulta.models.enums.SchedulingStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface SchedulingRepository extends JpaRepository<Scheduling, Integer> {

    @Query("SELECT a FROM Agendamento a WHERE a.paciente.idPaciente = :id")
    List<Scheduling> findBySchedulingByPatientId(@Param("id") Integer patientId);

    Optional<Scheduling> findByIdScheduling(Integer schedulingId);

    Optional<Scheduling> findFirstByPatient_User_UserIdOrderBySchedulingDateDesc(Integer userId);

    @Query("SELECT a FROM Agendamento a WHERE a.dtAtendimento = :dt_atendimento AND a.hrAtendimento = :hr_atendimento")
    Optional<Scheduling> findBySchedulingDateAndSchedulingTime(@Param("dt_atendimento") LocalDate schedulingDate,
                                                               @Param("hr_atendimento") LocalTime schedulingTime);

    Optional<Scheduling> findSchedulingBySchedulingDateAndSchedulingTimeAndStatus(LocalDate schedulingDate,
                                                                                  LocalTime schedulingTime,
                                                                                  SchedulingStatusEnum status);

    @Query("SELECT new com.bandtec.mais.consulta.models.dto.response.HoursResponseDTO(a.dtAtendimento, a.hrAtendimento, a.medico.idMedico) FROM Agendamento a WHERE a.medico.ubs.idUbs = :idUbs AND a.dtAtendimento = :dia")
    List<HoursResponseDTO> findTimeAndSchedulingDateByUbsId(@Param("idUbs") Integer ubsId,
                                                            @Param("dia") LocalDate day);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Agendamento a SET a.status = :status WHERE a.idAgendamento = :id_agendamento")
    void updateSchedulingStatus(@Param("id_agendamento") Integer schedulingId,
                                @Param("status") SchedulingStatusEnum status);

}
