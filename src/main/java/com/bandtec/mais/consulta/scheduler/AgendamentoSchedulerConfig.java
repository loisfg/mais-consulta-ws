package com.bandtec.mais.consulta.scheduler;

import com.bandtec.mais.consulta.domain.Consult;
import com.bandtec.mais.consulta.domain.Scheduling;
import com.bandtec.mais.consulta.gateway.repository.SchedulingRepository;
import com.bandtec.mais.consulta.gateway.repository.ConsultRepository;
import com.bandtec.mais.consulta.infra.queue.impl.SchedulingConsultQueueImpl;
import com.bandtec.mais.consulta.models.QueueObj;
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
    private final long SECOND = 1000;
    private final long MINUTE = SECOND * 60;
    private final long HOUR = MINUTE * 60;

    @Autowired
    private SchedulingRepository schedulingRepository;

    @Autowired
    private ConsultRepository consultRepository;

    private final QueueObj<Consult> queue = SchedulingConsultQueueImpl.getInstance();

    @Scheduled(fixedDelay = HOUR)
    public void getSchedules() {
        log.info("Try get schedules");
        List<Consult> consults = consultRepository.findConsultsByScheduling_Status(SchedulingStatusEnum.HOLD);
        queue.addList(consults);
    }

    @Scheduled(fixedRate = MINUTE * 30)
    public void handleSchedulingConsult() {
        if (!queue.isEmpty()) {
            Consult consult = queue.poll();
            log.info("Scheduling being changed || id_consulta {}", consult.getConsultId());
            Optional<Scheduling> scheduling = schedulingRepository.findSchedulingBySchedulingDateAndSchedulingTimeAndStatus(
                    consult.getScheduling().getSchedulingDate(), consult.getScheduling().getSchedulingTime(), SchedulingStatusEnum.CANCELLED);

            if (scheduling.isPresent()) {
                consult.getScheduling().setStatus(SchedulingStatusEnum.ACTIVE);
                schedulingRepository.updateSchedulingStatus(consult.getScheduling().getSchedulingId(), consult.getScheduling().getStatus());
            }
        } else {
            log.info("No schedules on HOLD || {}", "NOT_SCHEDULE_TIME");
        }
    }
}
