package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.usecase.export.ExportConsulta;
import com.bandtec.mais.consulta.usecase.export.ExportConsultaById;
import com.bandtec.mais.consulta.usecase.export.ExportLastConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("export")
public class ExportController {

    @Autowired
    private ExportLastConsulta exportLastConsulta;

    @Autowired
    private ExportConsultaById exportConsultaById;

    @Autowired
    private ExportConsulta exportConsulta;

    @GetMapping("/{idUser}/consulta/info")
    public ResponseEntity<?> exportLastConsulta(@PathVariable Integer idUser) {
        Optional<Map<String, String>> oAgendamentoCsv = exportLastConsulta.execute(idUser);

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

    @GetMapping("/{idAgendamento}/{idUser}/consulta/info")
    public ResponseEntity<?> exportConsultaById(@PathVariable Integer idAgendamento,
                                                @PathVariable Integer idUser) {

        Optional<Map<String, String>> oConsultaCsv = exportConsultaById.execute(idAgendamento, idUser);

        if (oConsultaCsv.isPresent()) {

            Map<String, String> agendamentoCsv = oConsultaCsv.get();

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

    @GetMapping("{idPaciente}/consultas/info")
    public ResponseEntity<?> exportConsulta(@PathVariable Integer idPaciente) {

        Optional<String> oConsultaCsv = exportConsulta.execute(idPaciente);

        if (oConsultaCsv.isPresent()) {

            String agendamentoCsv = oConsultaCsv.get();
            String extension = ".csv";

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=%s%s", "consultas", extension))
                    .contentLength(agendamentoCsv.length())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(agendamentoCsv);

        }
        return ResponseEntity.noContent().build();
    }

}
