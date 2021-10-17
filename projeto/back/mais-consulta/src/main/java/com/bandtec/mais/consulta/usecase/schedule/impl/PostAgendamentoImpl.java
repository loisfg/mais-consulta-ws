package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.gateway.database.repository.AgendamentoRepository;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoRequestDTO;
import com.bandtec.mais.consulta.usecase.schedule.PostAgendamento;
import com.bandtec.mais.consulta.usecase.schedule.AgendamentoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostAgendamentoImpl implements PostAgendamento {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Override
    public Agendamento execute(AgendamentoRequestDTO agendamentoRequestDTO) {
        Agendamento agendamento = new Agendamento();

        if (agendamentoRequestDTO.getEspecialidade().equals(AgendamentoEnum.GERAL.getDescription())) {
            buildFirstSchedule(agendamento, agendamentoRequestDTO);
            agendamentoRepository.save(agendamento);
        }

        return agendamento;
    }

    private void buildFirstSchedule(Agendamento agendamento, AgendamentoRequestDTO agendamentoDTO) {
        agendamento.setDataHr(agendamentoDTO.getDtHr());
        agendamento.setDtAtendimento(agendamentoDTO.getDtAtendimento());
        agendamento.setEspecialidade(agendamentoDTO.getEspecialidade());
        agendamento.setPaciente(agendamentoDTO.getAgendamento().getPaciente());
        agendamento.setMedico(agendamentoDTO.getAgendamento().getMedico());
    }
}
