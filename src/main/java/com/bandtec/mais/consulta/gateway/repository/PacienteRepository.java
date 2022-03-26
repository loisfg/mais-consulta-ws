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

public interface PacienteRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findByNomeContaining(String nome);

    List<Patient> findByEnderecoBairro(String bairro);

    Optional<Patient> findByUsuarioCpfAndUsuarioPassword(String cpf, String password);

    boolean existsByUsuarioCpf(String cpf);

    boolean existsByEnderecoCidade(String cidade);

    Optional<Patient> findByUsuario(User user);

    Optional<Patient> findByIdPaciente(Integer idPaciente);

    boolean existsByIdPaciente(Integer idPaciente);

    @Query("SELECT new com.bandtec.mais.consulta.models.dto.response.PacienteAgendamentosResponseDTO(a.idAgendamento, a.especialidade.descricao, a.dtAtendimento, a.hrAtendimento) FROM Agendamento a WHERE a.paciente.idPaciente = :id_paciente AND a.dtAtendimento BETWEEN :dt_start AND :dt_end")
    Optional<List<PatientSchedulingResponseDTO>> findAgendamentosToPaciente(@Param("id_paciente") Integer idPaciente,
                                                                            @Param("dt_start") LocalDate dtStart,
                                                                            @Param("dt_end") LocalDate dtEnd);

    @Query("SELECT new com.bandtec.mais.consulta.models.dto.response.PacienteHistoricoResponseDTO(a.idAgendamento, a.dtAtendimento, a.hrAtendimento, a.medico.especialidade.descricao, a.medico.nome, a.medico.ubs.nome) FROM Agendamento a WHERE a.paciente.idPaciente = :idPaciente")
    Optional<List<PatientHistoricResponseDTO>> findAllHistoricoPaciente(@Param("idPaciente") Integer idPaciente);


}
