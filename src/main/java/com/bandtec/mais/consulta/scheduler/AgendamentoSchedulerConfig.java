package com.bandtec.mais.consulta.scheduler;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.domain.Consulta;
import com.bandtec.mais.consulta.gateway.repository.AgendamentoRepository;
import com.bandtec.mais.consulta.gateway.repository.ConsultaRepository;
import com.bandtec.mais.consulta.infra.queue.impl.FilaAgendamentoConsultaImpl;
import com.bandtec.mais.consulta.models.FilaObj;
import com.bandtec.mais.consulta.models.enums.AgendamentoStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.Optional;

@Configuration
@EnableScheduling
@EnableAsync
@Slf4j
public class AgendamentoSchedulerConfig {
    private final long SEGUNDO = 1000;
    private final long MINUTO = SEGUNDO * 60;
    private final long HORA = MINUTO * 60;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    private final FilaObj<Consulta> fila = FilaAgendamentoConsultaImpl.getInstance();

    @Scheduled(fixedDelay = HORA)
    public void getAgendamentos() {
        log.info("Try get schedules");
        List<Consulta> consultas = consultaRepository.findConsultasByAgendamento_Status(AgendamentoStatusEnum.AGUARDE);
        fila.addList(consultas);
    }

    @Scheduled(fixedRate = MINUTO * 30)
    public void tratarAgendamentoConsulta() {
        if (!fila.isEmpty()) {
            Consulta consulta = fila.poll();
            log.info("Agendamento sendo alterado || id_consulta {}", consulta.getIdConsulta());
            Optional<Agendamento> agendamento = agendamentoRepository.findAgendamentoByDtAtendimentoAndHrAtendimentoAndStatus(
                    consulta.getAgendamento().getDtAtendimento(), consulta.getAgendamento().getHrAtendimento(), AgendamentoStatusEnum.CANCELADO);

            if (agendamento.isPresent()) {
                consulta.getAgendamento().setStatus(AgendamentoStatusEnum.ATIVO);
                agendamentoRepository.updateAgendamentoStatus(consulta.getAgendamento().getIdAgendamento(), consulta.getAgendamento().getStatus());
            }
        } else {
            log.info("Sem agendamentos em AGUARDE || {}", "NOT_SCHEDULE_TIME");
        }
    }
}
