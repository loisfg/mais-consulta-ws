package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.gateway.repository.AgendamentoRepository;
import com.bandtec.mais.consulta.gateway.repository.ConsultaRepository;
import com.bandtec.mais.consulta.models.dto.response.SchedulingResponseDTO;
import com.bandtec.mais.consulta.usecase.schedule.GetSchedulingConsult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetSchedulingConsultImpl implements GetSchedulingConsult {

    @Autowired
    ConsultaRepository consultaRepository;

    @Autowired
    AgendamentoRepository agendamentoRepository;

    @Override
    public Optional<List<SchedulingResponseDTO>> execute(Integer idUser) {
        Optional<List<SchedulingResponseDTO>> consultas = consultaRepository.findAllConsultaByIdUser(idUser);

        if (consultas.isEmpty()) {
            return Optional.of(List.of());
        }

        return consultas;
    }
}
