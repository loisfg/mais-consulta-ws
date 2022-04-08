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

    @Query("SELECT a FROM Scheduling a WHERE a.patient.patientId = :id")
    List<Scheduling> findBySchedulingByPatientId(@Param("id") Integer patientId);

    Optional<Scheduling> findBySchedulingId(Integer schedulingId);

    Optional<Scheduling> findFirstByPatient_User_UserIdOrderBySchedulingDateDesc(Integer userId);

    @Query("SELECT a FROM Scheduling a WHERE a.schedulingDate = :dt_atendimento AND a.schedulingTime = :hr_atendimento")
    Optional<Scheduling> findBySchedulingDateAndSchedulingTime(@Param("dt_atendimento") LocalDate schedulingDate,
                                                               @Param("hr_atendimento") LocalTime schedulingTime);

    Optional<Scheduling> findSchedulingBySchedulingDateAndSchedulingTimeAndStatus(LocalDate schedulingDate,
                                                                                  LocalTime schedulingTime,
                                                                                  SchedulingStatusEnum status);

    @Query("SELECT new com.bandtec.mais.consulta.models.dto.response.HoursResponseDTO(a.schedulingDate, a.schedulingTime, a.doctor.doctorId) FROM Scheduling a WHERE a.doctor.clinic.clinicId = :clinicId AND a.schedulingDate = :dia")
    List<HoursResponseDTO> findTimeAndSchedulingDateByClinicId(@Param("clinicId") Integer clinicId,
                                                               @Param("dia") LocalDate day);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Scheduling a SET a.status = :status WHERE a.schedulingId = :id_agendamento")
    void updateSchedulingStatus(@Param("id_agendamento") Integer schedulingId,
                                @Param("status") SchedulingStatusEnum status);

}
