package com.bandtec.mais.consulta.usecase.export;

import java.io.ByteArrayInputStream;

public interface ExportAgendamento {
    ByteArrayInputStream execute(Integer idUser, Integer idAgendamento);
}
