package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.error.ResourceNotFoundException;
import com.bandtec.mais.consulta.gateway.repository.AgendamentoRepository;
import com.bandtec.mais.consulta.gateway.repository.ExameRepository;
import com.bandtec.mais.consulta.gateway.repository.UsuarioRepository;
import com.bandtec.mais.consulta.models.dto.response.SchedulingResponseDTO;
import com.bandtec.mais.consulta.usecase.schedule.GetSchedulingExam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetSchedulingExamImpl implements GetSchedulingExam {

    @Autowired
    ExameRepository exameRepository;

    @Autowired
    AgendamentoRepository agendamentoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Optional<List<SchedulingResponseDTO>> execute(Integer idUser) {
        Optional<List<SchedulingResponseDTO>> exames = exameRepository.findAllExamesByIdUser(idUser);
        Optional user = usuarioRepository.findById(idUser);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("user ID :" +idUser+" NOT FOUND");
        }

        if (exames.isEmpty()) {
            return Optional.of(List.of());
        }

        return exames;
    }
}
