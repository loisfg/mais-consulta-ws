package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.error.ResourceNotFoundException;
import com.bandtec.mais.consulta.gateway.repository.SchedulingRepository;
import com.bandtec.mais.consulta.gateway.repository.ExamRepository;
import com.bandtec.mais.consulta.gateway.repository.UserRepository;
import com.bandtec.mais.consulta.models.dto.response.SchedulingResponseDTO;
import com.bandtec.mais.consulta.usecase.schedule.GetSchedulingExam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetSchedulingExamImpl implements GetSchedulingExam {

    @Autowired
    ExamRepository examRepository;

    @Autowired
    SchedulingRepository schedulingRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<List<SchedulingResponseDTO>> execute(Integer idUser) {
        Optional<List<SchedulingResponseDTO>> exames = examRepository.findAllExamsByUserId(idUser);
        Optional user = userRepository.findById(idUser);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("user ID :" +idUser+" NOT FOUND");
        }

        if (exames.isEmpty()) {
            return Optional.of(List.of());
        }

        return exames;
    }
}
