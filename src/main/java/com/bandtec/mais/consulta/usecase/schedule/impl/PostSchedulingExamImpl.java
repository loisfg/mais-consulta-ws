package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.domain.Scheduling;
import com.bandtec.mais.consulta.domain.Exam;
import com.bandtec.mais.consulta.gateway.repository.*;
import com.bandtec.mais.consulta.infra.queue.SchedulingExamQueue;
import com.bandtec.mais.consulta.models.dto.request.ExamSchedulingRequestDTO;
import com.bandtec.mais.consulta.models.enums.SchedulingStatusEnum;
import com.bandtec.mais.consulta.usecase.notification.CreateNotification;
import com.bandtec.mais.consulta.usecase.schedule.PostSchedulingExam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NonUniqueResultException;
import java.util.Optional;

@Service
@Slf4j
public class PostSchedulingExamImpl implements PostSchedulingExam {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private SchedulingRepository schedulingRepository;

    @Autowired
    private CreateNotification createNotification;

    @Autowired
    private SchedulingExamQueue schedulingExamQueue;

    @Override
    public Optional<Exam> execute(ExamSchedulingRequestDTO examSchedulingRequestDTO) {
        Exam exam = ExamSchedulingRequestDTO.convertFromController(examSchedulingRequestDTO);

        if (patientRepository.existsById(examSchedulingRequestDTO.getPatientId())) {
            try{
                Optional<Scheduling> oAgendamento = schedulingRepository.findBySchedulingDateAndSchedulingTime(examSchedulingRequestDTO.getSchedulingDate(), examSchedulingRequestDTO.getSchedulingTime());
                if (oAgendamento.isPresent()) {

                    Scheduling agendamento = oAgendamento.get();

                    if (agendamento.getStatus().equals(SchedulingStatusEnum.CANCELLED)) {
                        efetuarAgendamentoExame(examSchedulingRequestDTO, exam);
                    } else {
                        examSchedulingRequestDTO.setStatus(SchedulingStatusEnum.HOLD);
                        schedulingExamQueue.setSchedulingExamQueue(examSchedulingRequestDTO);
                        return Optional.of(exam);
                    }
                }

            }catch (NonUniqueResultException nonUniqueResultException){
                System.out.println("Tratar esse erro");
            }

            efetuarAgendamentoExame(examSchedulingRequestDTO, exam);
        }

        return Optional.of(exam);
    }

    private void efetuarAgendamentoExame(ExamSchedulingRequestDTO examSchedulingRequestDTO, Exam exam) {
        Scheduling agendamento = exam.getScheduling();
        agendamento.setStatus(SchedulingStatusEnum.ACTIVE);
        agendamento.setPaciente(patientRepository.findById(examSchedulingRequestDTO.getPatientId()).get());
        agendamento.setEspecialidade(specialtyRepository.findById(examSchedulingRequestDTO.getSpecialtyId()).get());
        agendamento.setMedico(doctorRepository.findDoctorsBySpecialtyIdAndUbsId(examSchedulingRequestDTO.getSpecialtyId(), examSchedulingRequestDTO.getUbsId()).get());

        examRepository.save(exam);
        schedulingRepository.save(agendamento);
        createNotification.execute(agendamento, "exame");
    }
}
