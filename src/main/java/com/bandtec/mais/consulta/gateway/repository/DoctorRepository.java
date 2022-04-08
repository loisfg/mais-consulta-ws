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

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    // TODO: Make DTO here, select is too big
    @Query(value = "SELECT m FROM Doctor m WHERE m.specialty.specialtyId = :idEspecialidade AND m.clinic.clinicId= :clinicId")
    Optional<Doctor> findDoctorsBySpecialtyIdAndClinicId(@Param("idEspecialidade") Integer specialtyId,
                                                         @Param("clinicId") Integer clinicId);

    @Query(value = "SELECT m.doctorId FROM Doctor m WHERE m.specialty.specialtyId = :idEspecialidade AND m.clinic.clinicId= :clinicId")
    Optional<List<Integer>> findDoctorsIdsBySpecialtyIdAndClinic(@Param("idEspecialidade") Integer specialtyId,
                                                                 @Param("clinicId") Integer clinicId);

    @Query(value = "SELECT new com.bandtec.mais.consulta.models.dto.response.DoctorSchedulingDTO(a.patient.patientId, a.schedulingId, a.patient.name,  a.schedulingTime, a.patient.birthDate) FROM Scheduling a WHERE a.schedulingDate = :dtAtual AND a.doctor.doctorId = :id AND a.status = 'ATIVO'")
    Optional<List<DoctorSchedulingDTO>> findAllSchedulesByDoctorId(@Param("id") Integer doctorId,
                                                                   @Param("dtAtual") LocalDate date);

    boolean existsByName(String name);

    List<Doctor> findByName(String name);

    Set<Doctor> findAllBySpecialty(Specialty specialty);

    @Query("select m from Doctor m")
    List<Doctor> findAllDoctors();

    Optional<Doctor> findByUser(User user);

    @Query("SELECT m FROM Doctor m WHERE m.clinic.clinicId = :clinicId")
    List<Doctor> findDoctorsByClinicId(@Param("clinicId") Integer clinicId);

    @Query("SELECT a.doctor FROM Scheduling a WHERE a.schedulingDate = :dt_atendimento AND a.schedulingTime = :hr_atendimento AND a.status <> :status")
    List<Doctor> findDoctorsByScheduling(@Param("dt_atendimento") LocalDate schedulingDate,
                                         @Param("hr_atendimento") LocalTime schedulingTime,
                                         @Param("status") String status);

    boolean existsByDoctorId(Integer doctorId);

    @Query("SELECT DISTINCT new com.bandtec.mais.consulta.models.dto.response.DoctorHistoricResponseDTO(a.schedulingId, a.patient.name, a.patient.birthDate, a.schedulingDate) FROM Scheduling a WHERE a.doctor.doctorId = :idMedico AND a.status = 'FINALIZADO'")
    Optional<List<DoctorHistoricResponseDTO>> findSchedulesHistoric(@Param("idMedico") Integer doctorId);
}
