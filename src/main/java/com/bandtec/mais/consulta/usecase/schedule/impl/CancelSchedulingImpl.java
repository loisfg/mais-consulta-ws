package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.domain.Scheduling;
import com.bandtec.mais.consulta.gateway.repository.AgendamentoRepository;
import com.bandtec.mais.consulta.usecase.schedule.CancelScheduling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.bandtec.mais.consulta.models.enums.SchedulingStatusEnum.CANCELLED;

@Service
public class CancelSchedulingImpl implements CancelScheduling {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Override
    public Optional<Scheduling> execute(Integer idAgendamento) {

        if (agendamentoRepository.existsById(idAgendamento)) {
            Scheduling agendamento = agendamentoRepository.findById(idAgendamento).orElseThrow();

            agendamentoRepository.updateAgendamentoStatus(agendamento.getIdAgendamento(), CANCELLED);

            return Optional.of(agendamento);
        }

        return Optional.empty();
    }
}
