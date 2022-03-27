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

        if (fds.queryFrom(consult.getScheduling().getDtAtendimento())) {
            log.info("Não realizamos agendamentos aos fins de semana {}", consult.getScheduling().getDtAtendimento());
            return Optional.empty();
        }

        if (patientRepository.existsById(consultSchedulingRequestDTO.getPatientId())) {
            log.info("Efetuando agendamento com status {}", consultSchedulingRequestDTO.getStatus());
            switch (consultSchedulingRequestDTO.getStatus()) {
                case ACTIVE:
                    efetuarAgendamentoConsulta(consultSchedulingRequestDTO, consult);
                    break;

                case HOLD:
                    schedulingConsultQueue.setSchedulingConsultQueue(consult);
                    break;

                case CANCELLED:
                case FINISHED:
                    break;

                default:
                    throw new IllegalStateException("Status não tratado: " + consultSchedulingRequestDTO.getStatus());
            }
        } else {
            log.info("Usuário não existe ou não é um paciente");
            return Optional.empty();
            // TODO adicionar Throw de usuário não existente.
        }

        return Optional.of(consult);
    }

    private void efetuarAgendamentoConsulta(ConsultSchedulingRequestDTO consultSchedulingRequestDTO, Consult consult) {
        // TODO Adicionar Excpetion para médico não encontrado (procurar locais que precisam e adicionar; por logs tb
        Scheduling agendamento = consult.getScheduling();
        Doctor doctor = doctorRepository.findDoctorsBySpecialtyIdAndUbsId
                (consultSchedulingRequestDTO.getSpecialtyId(), consultSchedulingRequestDTO.getUbsId()).orElseThrow();
        agendamento.setMedico(doctor);
        agendamento.setPaciente(patientRepository.findById(consultSchedulingRequestDTO.getPatientId()).get());
        agendamento.setEspecialidade(doctor.getSpecialty());

        consultRepository.save(consult);
        schedulingRepository.save(agendamento);

        createNotification.execute(agendamento, "consulta");
    }

    private final TemporalQuery<Boolean> fds = t -> {
        DayOfWeek dow = DayOfWeek.from(t);
        return dow == DayOfWeek.SATURDAY || dow == DayOfWeek.SUNDAY;
    };
}