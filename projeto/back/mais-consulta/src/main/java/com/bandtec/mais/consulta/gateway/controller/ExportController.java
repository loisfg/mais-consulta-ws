package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.usecase.export.ExportAgendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("export")
public class ExportController {

    @Autowired
    private ExportAgendamento exportAgendamento;

    @GetMapping("/{idUser}/consulta/info")
    public ResponseEntity<?> exportAgendamento(@PathVariable Integer idUser) {
        Optional<Map<String, String>> oAgendamentoCsv = exportAgendamento.execute(idUser);

        if (oAgendamentoCsv.isPresent()) {

            Map<String, String> agendamentoCsv = oAgendamentoCsv.get();

            String arquivo = agendamentoCsv.get("informacoesConsulta");
            String filename = agendamentoCsv.get("nomeArquivo");
            String extension = ".csv";

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=%s%s", filename, extension))
                    .contentLength(arquivo.length())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(arquivo);

        }
        return ResponseEntity.noContent().build();
    }

}
