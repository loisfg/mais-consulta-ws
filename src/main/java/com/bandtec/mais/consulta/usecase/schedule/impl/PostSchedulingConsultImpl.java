package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.gateway.repository.*;
import com.bandtec.mais.consulta.infra.queue.SchedulingConsultQueue;
import com.bandtec.mais.consulta.models.dto.request.ConsultSchedulingRequestDTO;
import com.bandtec.mais.consulta.usecase.notification.CreateNotification;
import com.bandtec.mais.consulta.usecase.schedule.PostSchedulingConsult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.temporal.TemporalQuery;
import java.util.*;

@Service
@Slf4j
@Primary
public class PostSchedulingConsultImpl implements PostSchedulingConsult {

    @Autowired
    private SchedulingRepository schedulingRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ConsultRepository consultRepository;

    @Autowired
    private CreateNotification createNotification;

    @Autowired
    private SchedulingConsultQueue schedulingConsultQueue;

    @Override
    public Optional<Consult> execute(ConsultSchedulingRequestDTO consultSchedulingRequestDTO) {
        Consult consult = ConsultSchedulingRequestDTO.convertFromController(consultSchedulingRequestDTO);

        if (fds.queryFrom(consult.getScheduling().getSchedulingDate())) {
            log.info("We do not provide schedules on weekends. {}", consult.getScheduling().getSchedulingDate());
            return Optional.empty();
        }

        if (patientRepository.existsById(consultSchedulingRequestDTO.getPatientId())) {
            log.info("Scheduling with status {}", consultSchedulingRequestDTO.getStatus());
            switch (consultSchedulingRequestDTO.getStatus()) {
                case ACTIVE:
                    makeSchedulingConsult(consultSchedulingRequestDTO, consult);
                    break;

                case HOLD:
                    schedulingConsultQueue.setSchedulingConsultQueue(consult);
                    break;

                case CANCELLED:
                case FINISHED:
                    break;

                default:
                    throw new IllegalStateException("Status not treated: " + consultSchedulingRequestDTO.getStatus());
            }
        } else {
            log.info("User does not exist or is not a patient");
            return Optional.empty();
            // TODO adicionar Throw de usuário não existente.
        }

        return Optional.of(consult);
    }

    private void makeSchedulingConsult(ConsultSchedulingRequestDTO consultSchedulingRequestDTO, Consult consult) {
        // TODO Adicionar Excpetion para médico não encontrado (procurar locais que precisam e adicionar; por logs tb
        Scheduling scheduling = consult.getScheduling();
        Doctor doctor = doctorRepository.findDoctorsBySpecialtyIdAndClinicId
                (consultSchedulingRequestDTO.getSpecialtyId(), consultSchedulingRequestDTO.getClinicId()).orElseThrow();
        scheduling.setDoctor(doctor);
        scheduling.setPatient(patientRepository.findById(consultSchedulingRequestDTO.getPatientId()).get());
        scheduling.setSpecialty(doctor.getSpecialty());

        consultRepository.save(consult);
        schedulingRepository.save(scheduling);

        createNotification.execute(scheduling, "consulta");
    }

    private final TemporalQuery<Boolean> fds = t -> {
        DayOfWeek dow = DayOfWeek.from(t);
        return dow == DayOfWeek.SATURDAY || dow == DayOfWeek.SUNDAY;
    };
}