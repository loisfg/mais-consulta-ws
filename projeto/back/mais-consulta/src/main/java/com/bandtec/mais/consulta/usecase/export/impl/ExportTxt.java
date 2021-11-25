package com.bandtec.mais.consulta.usecase.export.impl;

import java.util.Map;
import java.util.Optional;

public interface ExportTxt {
    Optional<Map<String, String>> execute(Integer idUser, Integer idAgendamento);

}
