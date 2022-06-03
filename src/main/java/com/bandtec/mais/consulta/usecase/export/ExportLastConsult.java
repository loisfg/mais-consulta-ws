package com.bandtec.mais.consulta.usecase.export;

import java.util.Map;
import java.util.Optional;

public interface ExportLastConsult {
    Optional<Map<String, String>> execute(Integer userId);
}
