package com.bandtec.mais.consulta.usecase.export;

import java.util.Map;
import java.util.Optional;

public interface ExportConsultaById {
    Optional<Map<String, String>> execute(Integer idAgendamento, Integer idUser);
}
