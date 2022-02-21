package com.bandtec.mais.consulta.scheduler;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.domain.Consulta;
import com.bandtec.mais.consulta.gateway.repository.AgendamentoRepository;
import com.bandtec.mais.consulta.infra.queue.FilaAgendamentoConsulta;
import com.bandtec.mais.consulta.models.FilaObj;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoConsultaRequestDTO;
import com.bandtec.mais.consulta.models.enums.AgendamentoStatusEnum;
import com.bandtec.mais.consulta.usecase.schedule.PostAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@EnableScheduling
@EnableAsync
//@Component
public abstract class AgendamentoSchedulerConfig implements PostAgendamentoConsulta {
    private final long SEGUNDO = 1000;
    private final long MINUTO = SEGUNDO * 60;
    private final long HORA = MINUTO * 60;

    @Autowired
    private FilaAgendamentoConsulta filaAgendamentoConsulta;

    @Scheduled(fixedRate = 5000L)
    public void tratarAgendamentoConsulta() {
        FilaObj<AgendamentoConsultaRequestDTO> fila = filaAgendamentoConsulta.getFilaAgendamentoConsulta();
        System.out.println(fila);
        if (!fila.isEmpty()) {
            execute(fila.poll());
        }
    }
}
/*
            AgendamentoConsultaRequestDTO consulta = fila.poll();
            Optional<Agendamento> agendamento = agendamentoRepository.findAgendamentoByDtAtendimentoAndHrAtendimentoAndStatus(
                    consulta.getDtAtendimento(), consulta.getHrAtendimento(), AgendamentoStatusEnum.CANCELADO);
            System.out.println(agendamento);

            if (agendamento.isPresent()) {
                consulta.setStatus(AgendamentoStatusEnum.ATIVO);
                execute(consulta);
            }
        }
 */
