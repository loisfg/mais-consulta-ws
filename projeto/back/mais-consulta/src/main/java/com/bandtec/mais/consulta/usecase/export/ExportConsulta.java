package com.bandtec.mais.consulta.usecase.export;

import java.util.Optional;

public interface ExportConsulta {
    Optional<String> execute(Integer idPaciente);
}
