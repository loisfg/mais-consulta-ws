package com.bandtec.mais.consulta.scheduler;

import com.bandtec.mais.consulta.infra.queue.FilaAgendamentoConsulta;
import com.bandtec.mais.consulta.infra.queue.FilaAgendamentoExame;
import com.bandtec.mais.consulta.models.FilaObj;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoConsultaRequestDTO;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoExameRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@EnableAsync
public class AgendamentoSchedulerConfig {

    @Autowired
    private FilaAgendamentoExame filaAgendamentoExame;

    @Autowired
    private FilaAgendamentoConsulta filaAgendamentoConsulta;


    @Scheduled(fixedRate = 5000)
    public void tratarAgendamentoConsulta() {
        FilaObj<AgendamentoConsultaRequestDTO> fila = filaAgendamentoConsulta.getFilaAgendamentoConsulta();

        if (fila.isEmpty()) {
            System.out.println("Nenhuma requisição para tratar");
        } else {
            System.out.println("entrou aqui : agendamento consulta");
        }
    }

    @Scheduled(fixedRate = 5000)
    public void tratarAgendamentoExame() {

        FilaObj<AgendamentoExameRequestDTO> fila = filaAgendamentoExame.getFilaAgendamentoExame();

        if (fila.isEmpty()) {
            System.out.println("Nenhuma requisição para tratar");
        } else {
            fila.exibe();
        }
    }

}
