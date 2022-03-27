package com.bandtec.mais.consulta.models.dto.response;

import com.bandtec.mais.consulta.domain.Consult;
import com.bandtec.mais.consulta.domain.Scheduling;
import com.bandtec.mais.consulta.domain.Doctor;
import com.bandtec.mais.consulta.domain.Patient;
import com.bandtec.mais.consulta.gateway.controller.SchedulingController;
import com.bandtec.mais.consulta.gateway.repository.SchedulingRepository;
import com.bandtec.mais.consulta.gateway.repository.ConsultRepository;
import com.bandtec.mais.consulta.gateway.repository.DoctorRepository;
import com.bandtec.mais.consulta.gateway.repository.PatientRepository;
import com.bandtec.mais.consulta.models.dto.request.ConsultSchedulingRequestDTO;
import com.bandtec.mais.consulta.models.enums.SchedulingStatusEnum;
import com.bandtec.mais.consulta.usecase.schedule.PostSchedulingConsult;
import com.bandtec.mais.consulta.usecase.schedule.impl.PostSchedulingConsultImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
class PostSchedulingConsultImplTest {

    @Autowired
    PostSchedulingConsult postSchedulingConsult;

    @Autowired
    PostSchedulingConsultImpl postAgendamentoConsultaImpl;

    @Autowired
    SchedulingController schedulingController;

    @MockBean
    SchedulingRepository schedulingRepository;

    @MockBean
    PatientRepository patientRepository;

    @MockBean
    ConsultRepository consultRepository;

    @MockBean
    DoctorRepository doctorRepository;

    private final List<Doctor> medicosList = List.of(mock(Doctor.class), mock(Doctor.class), mock(Doctor.class));
    private final List<Doctor> medicosOcupados = List.of(mock(Doctor.class));
    private final LocalDate dataAtendimento = LocalDate.now().plusMonths(2);
    private final LocalTime horaAtendimento = LocalTime.of(10, 30);
    private final Optional<Patient> oPaciente = Optional.of(mock(Patient.class));

    @Test
    @DisplayName("Agendamento deve estar sendo criado para daqui a 2 meses")
    void criarAgendamento_DoisMesesDepoisComHorario() {
        when(patientRepository.findByPatientId(1))
                .thenReturn(oPaciente);

        when(patientRepository.existsByPatientId(1))
                .thenReturn(true);

        when(schedulingRepository.findBySchedulingDateAndSchedulingTime(dataAtendimento, horaAtendimento))
                .thenReturn(Optional.of(mock(Scheduling.class)));

        when(doctorRepository.findDoctorsByUbsId(1))
                .thenReturn(medicosList);

        when(doctorRepository.findDoctorsByScheduling(dataAtendimento, horaAtendimento, SchedulingStatusEnum.CANCELLED.getDescription()))
                .thenReturn(medicosOcupados);

        ConsultSchedulingRequestDTO consultSchedulingRequestDTO = new ConsultSchedulingRequestDTO(dataAtendimento, horaAtendimento, "Consulta test", 1, 1, 1, SchedulingStatusEnum.HOLD);
        Optional<Consult> consulta = postSchedulingConsult.execute(consultSchedulingRequestDTO);

        assertEquals(consulta.get().getDescription(), "Consulta test");
        assertEquals(consulta.get().getScheduling().getHrAtendimento(), horaAtendimento);
        assertEquals(consulta.get().getScheduling().getDtAtendimento(), dataAtendimento);
    }

    @Test
    @DisplayName("Agendamento falha ao tentar no mesmo dia e horario existente")
    void erroAoAgendar_MesmoDia() {
        when(patientRepository.findByPatientId(1))
                .thenReturn(oPaciente);

        when(patientRepository.existsByPatientId(1))
                .thenReturn(true);

        when(schedulingRepository.findBySchedulingDateAndSchedulingTime(dataAtendimento, horaAtendimento))
                .thenReturn(Optional.of(mock(Scheduling.class)));

        when(doctorRepository.findDoctorsByUbsId(1))
                .thenReturn(medicosOcupados);

        when(doctorRepository.findDoctorsByScheduling(dataAtendimento, horaAtendimento, SchedulingStatusEnum.CANCELLED.getDescription()))
                .thenReturn(medicosOcupados);
    }

    @Test
    @DisplayName("Agendamento com campos faltando")
    void pacienteNaoSelecionouTodosCampos() {

    }

}