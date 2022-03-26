package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.domain.Scheduling;
import com.bandtec.mais.consulta.domain.Exam;
import com.bandtec.mais.consulta.gateway.repository.*;
import com.bandtec.mais.consulta.infra.queue.FilaAgendamentoExame;
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
    private PacienteRepository pacienteRepository;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private ExameRepository exameRepository;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private CreateNotification createNotification;

    @Autowired
    private FilaAgendamentoExame filaAgendamentoExame;

    @Override
    public Optional<Exam> execute(ExamSchedulingRequestDTO examSchedulingRequestDTO) {
        Exam exam = ExamSchedulingRequestDTO.convertFromController(examSchedulingRequestDTO);

        if (pacienteRepository.existsById(examSchedulingRequestDTO.getPatientId())) {
            try{
                Optional<Scheduling> oAgendamento = agendamentoRepository.findByDtAtendimentoAndHrAtendimento(examSchedulingRequestDTO.getSchedulingDate(), examSchedulingRequestDTO.getSchedulingTime());
                if (oAgendamento.isPresent()) {

                    Scheduling agendamento = oAgendamento.get();

                    if (agendamento.getStatus().equals(SchedulingStatusEnum.CANCELLED)) {
                        efetuarAgendamentoExame(examSchedulingRequestDTO, exam);
                    } else {
                        examSchedulingRequestDTO.setStatus(SchedulingStatusEnum.HOLD);
                        filaAgendamentoExame.setFilaAgendamentoExame(examSchedulingRequestDTO);
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
        agendamento.setPaciente(pacienteRepository.findById(examSchedulingRequestDTO.getPatientId()).get());
        agendamento.setEspecialidade(especialidadeRepository.findById(examSchedulingRequestDTO.getSpecialtyId()).get());
        agendamento.setMedico(medicoRepository.findMedicosByIdEspecialidadeAndIdUbs(examSchedulingRequestDTO.getSpecialtyId(), examSchedulingRequestDTO.getUbsId()).get());

        exameRepository.save(exam);
        agendamentoRepository.save(agendamento);
        createNotification.execute(agendamento, "exame");
    }
}
