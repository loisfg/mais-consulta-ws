package com.bandtec.mais.consulta.scheduler;

import com.bandtec.mais.consulta.gateway.controller.AgendamentoController;
import com.bandtec.mais.consulta.infra.queue.FilaAgendamentoConsulta;
import com.bandtec.mais.consulta.infra.queue.FilaAgendamentoExame;
import com.bandtec.mais.consulta.models.FilaObj;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoConsultaRequestDTO;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoExameRequestDTO;
import com.bandtec.mais.consulta.usecase.schedule.PostAgendamentoConsulta;
import com.bandtec.mais.consulta.usecase.schedule.PostAgendamentoExame;
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

    @Autowired
    private PostAgendamentoConsulta postAgendamentoConsulta;

    @Autowired
    private PostAgendamentoExame postAgendamentoExame;

    @Scheduled(fixedRate = 1000000000000l)
    public void tratarAgendamentoConsulta() {
        FilaObj<AgendamentoConsultaRequestDTO> fila = filaAgendamentoConsulta.getFilaAgendamentoConsulta();

        if (fila.isEmpty()) {
            System.out.println("Nenhuma requisição de consulta para tratar");
        } else {
            postAgendamentoConsulta.execute(fila.poll());
        }
    }

    @Scheduled(fixedRate = 1000000000000l)
    public void tratarAgendamentoExame() {

        FilaObj<AgendamentoExameRequestDTO> fila = filaAgendamentoExame.getFilaAgendamentoExame();

        if (fila.isEmpty()) {
            System.out.println("Nenhuma requisição de exame para tratar");
        } else {
            postAgendamentoExame.execute(fila.poll());
        }
    }

}
