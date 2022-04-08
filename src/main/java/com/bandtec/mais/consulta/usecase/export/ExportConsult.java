package com.bandtec.mais.consulta.usecase.export;

import java.util.Optional;

public interface ExportConsult {
    Optional<String> execute(Integer patientId);
}
