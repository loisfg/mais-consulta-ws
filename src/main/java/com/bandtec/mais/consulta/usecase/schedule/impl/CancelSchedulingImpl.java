package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.domain.Scheduling;
import com.bandtec.mais.consulta.gateway.repository.SchedulingRepository;
import com.bandtec.mais.consulta.usecase.schedule.CancelScheduling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.bandtec.mais.consulta.models.enums.SchedulingStatusEnum.CANCELLED;

@Service
public class CancelSchedulingImpl implements CancelScheduling {

    @Autowired
    private SchedulingRepository schedulingRepository;

    @Override
    public Optional<Scheduling> execute(Integer idAgendamento) {

        if (schedulingRepository.existsById(idAgendamento)) {
            Scheduling agendamento = schedulingRepository.findById(idAgendamento).orElseThrow();

            schedulingRepository.updateSchedulingStatus(agendamento.getSchedulingId(), CANCELLED);

            return Optional.of(agendamento);
        }

        return Optional.empty();
    }
}
