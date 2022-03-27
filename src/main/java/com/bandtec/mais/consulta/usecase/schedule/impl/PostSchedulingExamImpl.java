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
            try {
                Optional<Scheduling> oScheduling = schedulingRepository
                        .findBySchedulingDateAndSchedulingTime(examSchedulingRequestDTO
                                .getSchedulingDate(), examSchedulingRequestDTO.getSchedulingTime());
                if (oScheduling.isPresent()) {

                    Scheduling scheduling = oScheduling.get();

                    if (scheduling.getStatus().equals(SchedulingStatusEnum.CANCELLED)) {
                        makeExamScheduling(examSchedulingRequestDTO, exam);
                    } else {
                        examSchedulingRequestDTO.setStatus(SchedulingStatusEnum.HOLD);
                        schedulingExamQueue.setSchedulingExamQueue(examSchedulingRequestDTO);
                        return Optional.of(exam);
                    }
                }

            } catch (NonUniqueResultException nonUniqueResultException) {
                System.out.println("Treat this error");
            }

            makeExamScheduling(examSchedulingRequestDTO, exam);
        }

        return Optional.of(exam);
    }

    private void makeExamScheduling(ExamSchedulingRequestDTO examSchedulingRequestDTO, Exam exam) {
        Scheduling scheduling = exam.getScheduling();
        scheduling.setStatus(SchedulingStatusEnum.ACTIVE);
        scheduling.setPatient(patientRepository.findById(examSchedulingRequestDTO.getPatientId()).get());
        scheduling.setSpecialty(specialtyRepository.findById(examSchedulingRequestDTO.getSpecialtyId()).get());
        scheduling.setDoctor(doctorRepository.findDoctorsBySpecialtyIdAndUbsId(examSchedulingRequestDTO.getSpecialtyId(), examSchedulingRequestDTO.getUbsId()).get());

        examRepository.save(exam);
        schedulingRepository.save(scheduling);
        createNotification.execute(scheduling, "exame");
    }
}
