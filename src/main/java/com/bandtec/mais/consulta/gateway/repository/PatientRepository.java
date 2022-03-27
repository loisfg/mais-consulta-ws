package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Patient;
import com.bandtec.mais.consulta.domain.User;
import com.bandtec.mais.consulta.models.dto.response.PatientSchedulingResponseDTO;
import com.bandtec.mais.consulta.models.dto.response.PatientHistoricResponseDTO;
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

    @Query("SELECT new com.bandtec.mais.consulta.models.dto.response.PacienteAgendamentosResponseDTO(a.idAgendamento, a.especialidade.descricao, a.dtAtendimento, a.hrAtendimento) FROM Agendamento a WHERE a.paciente.idPaciente = :id_paciente AND a.dtAtendimento BETWEEN :dt_start AND :dt_end")
    Optional<List<PatientSchedulingResponseDTO>> findSchedulesToPatient(@Param("id_paciente") Integer patientId,
                                                                        @Param("dt_start") LocalDate startDate,
                                                                        @Param("dt_end") LocalDate endDate);

    @Query("SELECT new com.bandtec.mais.consulta.models.dto.response.PacienteHistoricoResponseDTO(a.idAgendamento, a.dtAtendimento, a.hrAtendimento, a.medico.especialidade.descricao, a.medico.nome, a.medico.ubs.nome) FROM Agendamento a WHERE a.paciente.idPaciente = :idPaciente")
    Optional<List<PatientHistoricResponseDTO>> findAllPatientHistoric(@Param("idPaciente") Integer patientId);


}
