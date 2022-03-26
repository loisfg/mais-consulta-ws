package com.bandtec.mais.consulta.infra.queue.impl;

import com.bandtec.mais.consulta.domain.Consult;
import com.bandtec.mais.consulta.gateway.repository.ConsultaRepository;
import com.bandtec.mais.consulta.infra.queue.FilaAgendamentoConsulta;
import com.bandtec.mais.consulta.models.FilaObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
@Scope("singleton")
public class FilaAgendamentoConsultaImpl implements FilaAgendamentoConsulta {

    private static FilaObj<Consult> instance;

    public static FilaObj<Consult> getInstance() {
        if (instance == null) instance = new FilaObj<>(1000);
        return instance;
    }

    @Autowired
    ConsultaRepository consultaRepository;

    @Override
    public FilaObj<Consult> getFilaAgendamentoConsulta() {
        return instance;
    }

    @Override
    public void setFilaAgendamentoConsulta(Consult consult) {
        instance.insert(consult);
    }
}
