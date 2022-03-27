package com.bandtec.mais.consulta.infra.queue.impl;

import com.bandtec.mais.consulta.models.QueueObj;
import com.bandtec.mais.consulta.models.dto.request.ExamSchedulingRequestDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class SchedulingExamQueueImpl implements com.bandtec.mais.consulta.infra.queue.SchedulingExamQueue {

    QueueObj<ExamSchedulingRequestDTO> SchedulingExamQueue = new QueueObj<>(100000);

    @Override
    public QueueObj<ExamSchedulingRequestDTO> getSchedulingExamQueue() {
        return SchedulingExamQueue;
    }

    @Override
    public void setSchedulingExamQueue(ExamSchedulingRequestDTO examSchedulingRequestDTO) {
        this.SchedulingExamQueue.insert(examSchedulingRequestDTO);
    }

}
