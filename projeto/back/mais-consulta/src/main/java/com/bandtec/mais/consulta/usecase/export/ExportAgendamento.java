package com.bandtec.mais.consulta.usecase.export;

import java.util.Map;
import java.util.Optional;

public interface ExportAgendamento {
    Optional<Map<String, String>> execute(Integer idUser, Integer idAgendamento);
}
