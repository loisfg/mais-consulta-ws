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
    PostSchedulingConsultImpl postSchedulingConsultImpl;

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

    private final List<Doctor> doctorsList = List.of(mock(Doctor.class), mock(Doctor.class), mock(Doctor.class));
    private final List<Doctor> busyDoctors = List.of(mock(Doctor.class));
    private final LocalDate schedulingDate = LocalDate.now().plusMonths(2);
    private final LocalTime schedulingTime = LocalTime.of(10, 30);
    private final Optional<Patient> oPatient = Optional.of(mock(Patient.class));

    @Test
    @DisplayName("Agendamento deve estar sendo criado para daqui a 2 meses")
    void createScheduling_TwoMonthsAfterWithHour() {
        when(patientRepository.findByPatientId(1))
                .thenReturn(oPatient);

        when(patientRepository.existsByPatientId(1))
                .thenReturn(true);

        when(schedulingRepository.findBySchedulingDateAndSchedulingTime(schedulingDate, schedulingTime))
                .thenReturn(Optional.of(mock(Scheduling.class)));

        when(doctorRepository.findDoctorsByClinicId(1))
                .thenReturn(doctorsList);

        when(doctorRepository.findDoctorsByScheduling(schedulingDate, schedulingTime, SchedulingStatusEnum
                .CANCELLED.getDescription()))
                .thenReturn(busyDoctors);

        ConsultSchedulingRequestDTO consultSchedulingRequestDTO = new ConsultSchedulingRequestDTO(
                schedulingDate,
                schedulingTime,
                "Consulta test",
                1,
                1,
                1,
                SchedulingStatusEnum.HOLD);
        Optional<Consult> consult = postSchedulingConsult.execute(consultSchedulingRequestDTO);

        assertEquals(consult.get().getDescription(), "Consulta test");
        assertEquals(consult.get().getScheduling().getSchedulingTime(), schedulingTime);
        assertEquals(consult.get().getScheduling().getSchedulingDate(), schedulingDate);
    }

    @Test
    @DisplayName("Agendamento falha ao tentar no mesmo dia e horario existente")
    void errorInSchedule_SameDay() {
        when(patientRepository.findByPatientId(1))
                .thenReturn(oPatient);

        when(patientRepository.existsByPatientId(1))
                .thenReturn(true);

        when(schedulingRepository.findBySchedulingDateAndSchedulingTime(schedulingDate, schedulingTime))
                .thenReturn(Optional.of(mock(Scheduling.class)));

        when(doctorRepository.findDoctorsByClinicId(1))
                .thenReturn(busyDoctors);

        when(doctorRepository.findDoctorsByScheduling(schedulingDate, schedulingTime, SchedulingStatusEnum
                .CANCELLED.getDescription()))
                .thenReturn(busyDoctors);
    }

}