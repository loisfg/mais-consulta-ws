package com.bandtec.mais.consulta.infra.queue.impl;

import com.bandtec.mais.consulta.domain.Consulta;
import com.bandtec.mais.consulta.gateway.repository.ConsultaRepository;
import com.bandtec.mais.consulta.infra.queue.FilaAgendamentoConsulta;
import com.bandtec.mais.consulta.models.FilaObj;
import com.bandtec.mais.consulta.utils.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
@Scope("singleton")
public class FilaAgendamentoConsultaImpl implements FilaAgendamentoConsulta {

    private static FilaObj<Consulta> instance;

    public static FilaObj<Consulta> getInstance() {
        if (instance == null) instance = new FilaObj<Consulta>(1000);
        return instance;
    }

    @Autowired
    ConsultaRepository consultaRepository;

    @Override
    public FilaObj<Consulta> getFilaAgendamentoConsulta() {
        return instance;
    }

    @Override
    public void setFilaAgendamentoConsulta(Consulta consulta) {
        instance.insert(consulta);
    }
}
