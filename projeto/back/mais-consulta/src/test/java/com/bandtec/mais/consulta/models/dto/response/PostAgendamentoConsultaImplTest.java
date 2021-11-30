package com.bandtec.mais.consulta.models.dto.response;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.domain.Consulta;
import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.domain.Paciente;
import com.bandtec.mais.consulta.gateway.controller.AgendamentoController;
import com.bandtec.mais.consulta.gateway.repository.AgendamentoRepository;
import com.bandtec.mais.consulta.gateway.repository.ConsultaRepository;
import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoConsultaRequestDTO;
import com.bandtec.mais.consulta.usecase.schedule.PostAgendamentoConsulta;
import com.bandtec.mais.consulta.usecase.schedule.impl.PostAgendamentoConsultaImpl;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class PostAgendamentoConsultaImplTest {

    @Autowired
    PostAgendamentoConsulta postAgendamentoConsulta;

    @Autowired
    PostAgendamentoConsultaImpl postAgendamentoConsultaImpl;


    @Autowired
    AgendamentoController agendamentoController;

    @MockBean
    AgendamentoRepository agendamentoRepository;

    @MockBean
    PacienteRepository pacienteRepository;

    @MockBean
    ConsultaRepository consultaRepository;

    @MockBean
    MedicoRepository medicoRepository;

    private final List<Medico> medicosList = List.of(mock(Medico.class), mock(Medico.class), mock(Medico.class));
    private final List<Medico> medicosOcupados = List.of(mock(Medico.class));
    private final LocalDate dataAtendimento = LocalDate.now().plusMonths(2);
    private final LocalTime horaAtendimento = LocalTime.of(10, 30);
    private final Optional<Paciente> oPaciente = Optional.of(mock(Paciente.class));

    @Test
    @DisplayName("Agendamento deve estar sendo criado para daqui a 2 meses")
    void criarAgendamento_DoisMesesDepoisComHorario() {
        when(pacienteRepository.findByIdPaciente(1))
                .thenReturn(oPaciente);

        when(pacienteRepository.existsByIdPaciente(1))
                .thenReturn(true);

        when(agendamentoRepository.findByDtAtendimentoAndHrAtendimento(dataAtendimento, horaAtendimento))
                .thenReturn(Optional.of(mock(Agendamento.class)));

        when(medicoRepository.findMedicosByUbsId(1))
                .thenReturn(medicosList);

        when(medicoRepository.findMedicosByAgendamento(dataAtendimento, horaAtendimento))
                .thenReturn(medicosOcupados);

        AgendamentoConsultaRequestDTO agendamentoConsultaRequestDTO = new AgendamentoConsultaRequestDTO(dataAtendimento, horaAtendimento, "Consulta test", 1, 1, 1, "PEND");
        Optional<Consulta> consulta = postAgendamentoConsulta.execute(agendamentoConsultaRequestDTO);

        assertEquals(consulta.get().getDescricao(), "Consulta test");
        assertEquals(consulta.get().getAgendamento().getHrAtendimento(), horaAtendimento);
        assertEquals(consulta.get().getAgendamento().getDtAtendimento(), dataAtendimento);
    }

    @Test
    @DisplayName("Agendamento falha ao tentar no mesmo dia e horario existente")
    void erroAoAgendar_MesmoDia() {
        when(pacienteRepository.findByIdPaciente(1))
                .thenReturn(oPaciente);

        when(pacienteRepository.existsByIdPaciente(1))
                .thenReturn(true);

        when(agendamentoRepository.findByDtAtendimentoAndHrAtendimento(dataAtendimento, horaAtendimento))
                .thenReturn(Optional.of(mock(Agendamento.class)));

        when(medicoRepository.findMedicosByUbsId(1))
                .thenReturn(medicosOcupados);

        when(medicoRepository.findMedicosByAgendamento(dataAtendimento, horaAtendimento))
                .thenReturn(medicosOcupados);

    }

    @Test
    @DisplayName("Agendamento com campos faltando")
    void pacienteNaoSelecionouTodosCampos() {

    }

}