package com.bandtec.mais.consulta.infra.queue;

import com.bandtec.mais.consulta.domain.Consult;
import com.bandtec.mais.consulta.models.QueueObj;

public interface SchedulingConsultQueue {
    QueueObj<Consult> getSchedulingConsultQueue();
    void setSchedulingConsultQueue(Consult consult);
}
