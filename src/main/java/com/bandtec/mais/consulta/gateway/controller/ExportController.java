package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.usecase.export.ExportConsult;
import com.bandtec.mais.consulta.usecase.export.ExportConsultById;
import com.bandtec.mais.consulta.usecase.export.ExportLastConsult;
import com.bandtec.mais.consulta.validation.Validation;
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
    private ExportLastConsult exportLastConsult;

    @Autowired
    private ExportConsultById exportConsultById;

    @Autowired
    private ExportConsult exportConsult;

    @Autowired
    private Validation validation;

    @GetMapping("/{idUser}/consulta/info")
    public ResponseEntity<?> exportLastConsult(@PathVariable Integer userId) {
        Optional<Map<String, String>> oSchedulingCsv = exportLastConsult.execute(userId);

        if (oSchedulingCsv.isPresent()) {

            Map<String, String> schedulingCsv = oSchedulingCsv.get();

            String file = schedulingCsv.get("consultInfo");
            String filename = schedulingCsv.get("fileName");
            String extension = ".csv";

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=%s%s", filename, extension))
                    .contentLength(file.length())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(file);

        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{schedulingId}/{idUser}/consulta/info")
    public ResponseEntity<?> exportConsultById(@PathVariable Integer schedulingId,
                                               @PathVariable Integer idUser) {

        Optional<Map<String, String>> oConsultCsv = exportConsultById.execute(schedulingId, idUser);

        if (oConsultCsv.isPresent()) {

            Map<String, String> schedulingCsv = oConsultCsv.get();

            String file = schedulingCsv.get("informacoesConsulta");
            String filename = schedulingCsv.get("nomeArquivo");
            String extension = ".csv";

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=%s%s", filename, extension))
                    .contentLength(file.length())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(file);

        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping("{patientId}/consultas/info")
    public ResponseEntity<?> exportConsult(@PathVariable Integer patientId) {

        Optional<String> oConsultCsv = exportConsult.execute(patientId);

        if (oConsultCsv.isPresent()) {

            String schedulingCsv = oConsultCsv.get();
            String extension = ".csv";

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=%s%s", "consults", extension))
                    .contentLength(schedulingCsv.length())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(schedulingCsv);

        }
        return ResponseEntity.noContent().build();
    }

}
