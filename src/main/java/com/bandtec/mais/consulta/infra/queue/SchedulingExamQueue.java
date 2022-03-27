package com.bandtec.mais.consulta.infra.queue;

import com.bandtec.mais.consulta.models.QueueObj;
import com.bandtec.mais.consulta.models.dto.request.ExamSchedulingRequestDTO;

public interface SchedulingExamQueue {
    QueueObj<ExamSchedulingRequestDTO> getSchedulingExamQueue();
    void setSchedulingExamQueue(ExamSchedulingRequestDTO examSchedulingRequestDTO);
}
