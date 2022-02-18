package com.bandtec.mais.consulta.usecase.schedule;

import com.bandtec.mais.consulta.domain.Agendamento;

import java.util.Optional;

public interface CancelAgendamento {
    Optional<Agendamento> execute(Integer idAgendamento);
}
