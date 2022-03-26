package com.bandtec.mais.consulta.usecase.schedule;

import com.bandtec.mais.consulta.domain.Scheduling;

import java.util.Optional;

public interface CancelScheduling {
    Optional<Scheduling> execute(Integer idAgendamento);
}
