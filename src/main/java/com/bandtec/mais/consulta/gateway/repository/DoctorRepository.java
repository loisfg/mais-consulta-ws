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

    @Query(value = "SELECT m.idMedico FROM Medico m WHERE m.especialidade.idEspecialidade = :idEspecialidade AND m.ubs.idUbs=:idUbs")
    List<Integer> findDoctorsIdsBySpecialtyIdAndUbsId(@Param("idEspecialidade") Integer specialtyId,
                                                      @Param("idUbs") Integer ubsId);

    // TODO: Make DTO here, select is too big
    @Query(value = "SELECT m FROM Medico m WHERE m.especialidade.idEspecialidade = :idEspecialidade AND m.ubs.idUbs= :idUbs")
    Optional<Doctor> findDoctorsBySpecialtyIdAndUbsId(@Param("idEspecialidade") Integer specialtyId,
                                                      @Param("idUbs") Integer ubsId);

    @Query(value = "SELECT m.idMedico FROM Medico m WHERE m.especialidade.idEspecialidade = :idEspecialidade AND m.ubs.idUbs= :idUbs")
    Optional<List<Integer>> findDoctorsIdsBySpecialtyIdAndUbs(@Param("idEspecialidade") Integer specialtyId,
                                                              @Param("idUbs") Integer ubsId);

    @Query(value = "SELECT new com.bandtec.mais.consulta.models.dto.response.MedicoAgendamentoDTO(a.paciente.idPaciente, a.idAgendamento, a.paciente.nome,  a.hrAtendimento, a.paciente.dtNascimento) FROM Agendamento a WHERE a.dtAtendimento = :dtAtual AND a.medico.idMedico = :id AND a.status = 'ATIVO'")
    Optional<List<DoctorSchedulingDTO>> findAllSchedulesByDoctorId(@Param("id") Integer doctorId,
                                                                   @Param("dtAtual") LocalDate date);

    boolean existsByName(String name);

    List<Doctor> findByName(String name);

    Set<Doctor> findAllBySpecialties(Specialty specialty);

    @Query("select m from Medico m")
    List<Doctor> findAllDoctors();

    Optional<Doctor> findByUser(User user);

    @Query("SELECT m FROM Medico m WHERE m.ubs.idUbs = :id_ubs")
    List<Doctor> findDoctorsByUbsId(@Param("id_ubs") Integer ubsId);

    @Query("SELECT a.medico FROM Agendamento a WHERE a.dtAtendimento = :dt_atendimento AND a.hrAtendimento = :hr_atendimento AND a.status <> :status")
    List<Doctor> findDoctorsByScheduling(@Param("dt_atendimento") LocalDate schedulingDate,
                                         @Param("hr_atendimento") LocalTime schedulingTime,
                                         @Param("status") String status);

    boolean existsByDoctorId(Integer doctorId);

    @Query("SELECT DISTINCT new com.bandtec.mais.consulta.models.dto.response.MedicoHistoricoResponseDTO(a.idAgendamento, a.paciente.nome, a.paciente.dtNascimento, a.dtAtendimento) FROM Agendamento a WHERE a.medico.idMedico = :idMedico AND a.status = 'FINALIZADO'")
    Optional<List<DoctorHistoricResponseDTO>> findSchedulesHistoric(@Param("idMedico") Integer doctorId);
}
