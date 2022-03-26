package com.bandtec.mais.consulta.usecase.schedule;

import com.bandtec.mais.consulta.domain.Exam;
import com.bandtec.mais.consulta.models.dto.request.ExamSchedulingRequestDTO;

import java.util.Optional;

public interface PostSchedulingExam {
    Optional<Exam> execute(ExamSchedulingRequestDTO examSchedulingRequestDTO);
}
