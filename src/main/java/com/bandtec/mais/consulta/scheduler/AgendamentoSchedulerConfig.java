package com.bandtec.mais.consulta.scheduler;

import com.bandtec.mais.consulta.domain.Consult;
import com.bandtec.mais.consulta.domain.Scheduling;
import com.bandtec.mais.consulta.gateway.repository.AgendamentoRepository;
import com.bandtec.mais.consulta.gateway.repository.ConsultaRepository;
import com.bandtec.mais.consulta.infra.queue.impl.FilaAgendamentoConsultaImpl;
import com.bandtec.mais.consulta.models.FilaObj;
import com.bandtec.mais.consulta.models.enums.SchedulingStatusEnum;
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

    private final FilaObj<Consult> fila = FilaAgendamentoConsultaImpl.getInstance();

    @Scheduled(fixedDelay = HORA)
    public void getAgendamentos() {
        log.info("Try get schedules");
        List<Consult> consults = consultaRepository.findConsultasByAgendamento_Status(SchedulingStatusEnum.HOLD);
        fila.addList(consults);
    }

    @Scheduled(fixedRate = MINUTO * 30)
    public void tratarAgendamentoConsulta() {
        if (!fila.isEmpty()) {
            Consult consult = fila.poll();
            log.info("Agendamento sendo alterado || id_consulta {}", consult.getConsultId());
            Optional<Scheduling> agendamento = agendamentoRepository.findAgendamentoByDtAtendimentoAndHrAtendimentoAndStatus(
                    consult.getScheduling().getDtAtendimento(), consult.getScheduling().getHrAtendimento(), SchedulingStatusEnum.CANCELLED);

            if (agendamento.isPresent()) {
                consult.getScheduling().setStatus(SchedulingStatusEnum.ACTIVE);
                agendamentoRepository.updateAgendamentoStatus(consult.getScheduling().getIdAgendamento(), consult.getScheduling().getStatus());
            }
        } else {
            log.info("Sem agendamentos em AGUARDE || {}", "NOT_SCHEDULE_TIME");
        }
    }
}
