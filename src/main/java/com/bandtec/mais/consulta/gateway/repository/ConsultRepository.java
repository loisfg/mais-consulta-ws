package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Consult;
import com.bandtec.mais.consulta.models.dto.response.SchedulingResponseDTO;
import com.bandtec.mais.consulta.models.enums.SchedulingStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ConsultRepository extends JpaRepository<Consult, Integer> {

    @Query(value = "SELECT new com.bandtec.mais.consulta.models.dto.response.SchedulingResponseDTO(c.description, c.scheduling.schedulingDate, c.scheduling.schedulingTime, c.scheduling.specialty.description) FROM Consult c WHERE c.scheduling.patient.patientId = :id")
    Optional<List<SchedulingResponseDTO>> findAllConsultsByUserId(@Param("id") Integer userId);

    List<Consult> findConsultsByScheduling_Status(SchedulingStatusEnum status);

}