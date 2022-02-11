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
    public Optional<Agendamento> execute(Integer idPaciente, Integer idAgendamento) {

        if (agendamentoRepository.existsById(idAgendamento)) {

            agendamentoRepository.updateAgendamentoStatus(idAgendamento, AgendamentoStatusEnum.CANCELADO.getDescription(), idPaciente);

            return Optional.of(agendamentoRepository.getById(idAgendamento));
        }

        return Optional.empty();
    }
}
