package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.models.dto.response.HoursResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

    Optional<Agendamento> findByIdAgendamento(Integer idAgendamento);

    Optional<Agendamento> findByIdAgendamentoAndPaciente_IdPaciente(Integer idAgendamento, Integer idPaciente);

    @Query("SELECT a FROM Agendamento a WHERE a.dtAtendimento = :dt_atendimento AND a.hrAtendimento = :hr_atendimento")
    Optional<Agendamento> findByDtAtendimentoAndHrAtendimento(@Param("dt_atendimento") LocalDate dtAtendimento,
                                                              @Param("hr_atendimento") LocalTime hrAtendimento);

    @Query("SELECT new com.bandtec.mais.consulta.models.dto.response.HoursResponseDTO(a.dtAtendimento, a.hrAtendimento, a.medico.idMedico) FROM Agendamento a WHERE a.medico.ubs.idUbs = :idUbs AND a.medico.especialidade.idEspecialidade = :idEspecialidade")
    List<HoursResponseDTO> findHrAndDtAtendimentoByIdUbs(@Param("idUbs") Integer idUbs,
                                                         @Param("idEspecialidade") Integer idEspecialidade);

}
