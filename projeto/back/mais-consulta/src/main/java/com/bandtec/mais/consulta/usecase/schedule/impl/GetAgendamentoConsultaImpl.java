package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.gateway.repository.AgendamentoRepository;
import com.bandtec.mais.consulta.gateway.repository.ConsultaRepository;
import com.bandtec.mais.consulta.models.dto.response.AgendamentoConsultaResponseDTO;
import com.bandtec.mais.consulta.usecase.schedule.GetAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetAgendamentoConsultaImpl implements GetAgendamentoConsulta {

    @Autowired
    ConsultaRepository consultaRepository;

    @Autowired
    AgendamentoRepository agendamentoRepository;

    @Override
    public Optional<List<AgendamentoConsultaResponseDTO>> execute(Integer idUser) {
        Optional<List<AgendamentoConsultaResponseDTO>> consultas = consultaRepository.findAllConsultaByIdUser(idUser);

        if (consultas.isEmpty()) {
            return Optional.of(List.of());
        }

        return consultas;
    }
}
