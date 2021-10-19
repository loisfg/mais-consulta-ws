package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.gateway.database.repository.AgendamentoRepository;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoConsultaRequestDTO;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoExameRequestDTO;
import com.bandtec.mais.consulta.usecase.schedule.PostAgendamentoConsulta;
import com.bandtec.mais.consulta.usecase.schedule.PostAgendamentoExame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PostAgendamentoExameImpl implements PostAgendamentoExame {
    @Autowired
    private AgendamentoRepository agendamentoExameRepository;

    @Override
    public Agendamento execute(AgendamentoExameRequestDTO agendamentoExameRequestDTO) {
        Agendamento agendamento = new Agendamento();

        buildSchedule(agendamento, agendamentoExameRequestDTO);
        agendamentoExameRepository.save(agendamento);

        return agendamento;
    }

    private void buildSchedule(Agendamento agendamento, AgendamentoExameRequestDTO agendamentoDTO) {
        agendamento.setDataHr(agendamentoDTO.getDtHr());
        agendamento.setDtAtendimento(agendamentoDTO.getDtAtendimento());
        LocalDate dataAgendamento = agendamentoDTO.getDtHr();
    }
}
