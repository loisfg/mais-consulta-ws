package com.bandtec.mais.consulta.usecase.export;

import java.util.Map;
import java.util.Optional;

public interface ExportConsultById {
    Optional<Map<String, String>> execute(Integer schedulingId, Integer userId);
}
