package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.models.dto.request.ClinicPostRequestDTO;
import com.bandtec.mais.consulta.usecase.export.ImportCsv;
import com.bandtec.mais.consulta.usecase.clinic.PostClinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clinica")
public class ClinicController {

    @Autowired
    private PostClinic postClinic;

    @Autowired
    private ImportCsv importCsv;

    @PostMapping
    public ResponseEntity<?> postClinic(@RequestBody ClinicPostRequestDTO clinicPostRequestDTO) {
        return ResponseEntity.of(postClinic.execute(clinicPostRequestDTO));
    }

    @PostMapping("/import")
    public ResponseEntity<?> postAllClinics() {
        importCsv.run();

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
