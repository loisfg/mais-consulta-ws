package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Patient;
import com.bandtec.mais.consulta.domain.User;
import com.bandtec.mais.consulta.models.dto.response.PatientHistoricMobileResponseDTO;
import com.bandtec.mais.consulta.models.dto.response.PatientHistoricResponseDTO;
import com.bandtec.mais.consulta.models.dto.response.PatientSchedulingResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findByNameContaining(String name);

    List<Patient> findByAddressDistrict(String district);

    Optional<Patient> findByUserCpfAndUserPassword(String cpf, String password);

    boolean existsByUserCpf(String cpf);

    boolean existsByAddressCity(String city);

    Optional<Patient> findByUser(User user);

    Optional<Patient> findByPatientId(Integer patientId);

    boolean existsByPatientId(Integer patientId);

    @Query("SELECT new com.bandtec.mais.consulta.models.dto.response.PatientSchedulingResponseDTO(a.schedulingId, a.specialty.description, a.schedulingDate, a.schedulingTime) FROM Scheduling a WHERE a.patient.patientId = :id_paciente AND a.schedulingDate BETWEEN :dt_start AND :dt_end")
    Optional<List<PatientSchedulingResponseDTO>> findSchedulesToPatient(@Param("id_paciente") Integer patientId,
                                                                        @Param("dt_start") LocalDate startDate,
                                                                        @Param("dt_end") LocalDate endDate);

    @Query("SELECT new com.bandtec.mais.consulta.models.dto.response.PatientHistoricResponseDTO(a.schedulingId, a.schedulingDate, a.schedulingTime, a.doctor.specialty.description, a.doctor.name, a.doctor.clinic.name) FROM Scheduling a WHERE a.patient.patientId = :idPaciente")
    Optional<List<PatientHistoricResponseDTO>> findAllPatientHistoric(@Param("idPaciente") Integer patientId);


    @Query("SELECT new com.bandtec.mais.consulta.models.dto.response.PatientHistoricMobileResponseDTO(a.doctor.clinic.address.street,a.doctor.clinic.address.district, a.doctor.clinic.address.state, a.schedulingId, a.schedulingDate, a.schedulingTime, a.doctor.specialty.description, a.doctor.name, a.doctor.clinic.name) FROM Scheduling a WHERE a.patient.patientId = :idPaciente")
    Optional<List<PatientHistoricMobileResponseDTO>> findAllPatientHistoricMobile(@Param("idPaciente") Integer patientId);
}
