package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.gateway.repository.SchedulingRepository;
import com.bandtec.mais.consulta.gateway.repository.ConsultRepository;
import com.bandtec.mais.consulta.models.dto.response.SchedulingResponseDTO;
import com.bandtec.mais.consulta.usecase.schedule.GetSchedulingConsult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetSchedulingConsultImpl implements GetSchedulingConsult {

    @Autowired
    ConsultRepository consultRepository;

    @Autowired
    SchedulingRepository schedulingRepository;

    @Override
    public Optional<List<SchedulingResponseDTO>> execute(Integer idUser) {
        Optional<List<SchedulingResponseDTO>> consultas = consultRepository.findAllConsultsByIdUser(idUser);

        if (consultas.isEmpty()) {
            return Optional.of(List.of());
        }

        return consultas;
    }
}
