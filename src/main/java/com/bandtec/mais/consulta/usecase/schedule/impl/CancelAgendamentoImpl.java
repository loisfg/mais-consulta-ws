package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.gateway.repository.AgendamentoRepository;
import com.bandtec.mais.consulta.models.enums.AgendamentoStatusEnum;
import com.bandtec.mais.consulta.usecase.schedule.CancelAgendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CancelAgendamentoImpl implements CancelAgendamento {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Override
    public Optional<Agendamento> execute(Integer idAgendamento) {

        if (agendamentoRepository.existsById(idAgendamento)) {
            Agendamento agendamento = agendamentoRepository.findById(idAgendamento).get();

            agendamentoRepository.updateAgendamentoStatus(agendamento.getIdAgendamento(), AgendamentoStatusEnum.statusAgendamento("CANCELADO"));

            return Optional.of(agendamento);
        }

        return Optional.empty();
    }
}
