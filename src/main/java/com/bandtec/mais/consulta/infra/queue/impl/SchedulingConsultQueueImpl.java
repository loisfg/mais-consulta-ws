package com.bandtec.mais.consulta.infra.queue.impl;

import com.bandtec.mais.consulta.domain.Consult;
import com.bandtec.mais.consulta.gateway.repository.ConsultRepository;
import com.bandtec.mais.consulta.infra.queue.SchedulingConsultQueue;
import com.bandtec.mais.consulta.models.QueueObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
@Scope("singleton")
public class SchedulingConsultQueueImpl implements SchedulingConsultQueue {

    private static QueueObj<Consult> instance;

    public static QueueObj<Consult> getInstance() {
        if (instance == null) instance = new QueueObj<>(1000);
        return instance;
    }

    @Autowired
    ConsultRepository consultRepository;

    @Override
    public QueueObj<Consult> getSchedulingConsultQueue() {
        return instance;
    }

    @Override
    public void setSchedulingConsultQueue(Consult consult) {
        instance.insert(consult);
    }
}
