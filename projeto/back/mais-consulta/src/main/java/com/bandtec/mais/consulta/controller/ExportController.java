package com.bandtec.mais.consulta.controller;

import com.bandtec.mais.consulta.usecase.export.ExportAgendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("export")
public class ExportController {

    @Autowired
    private ExportAgendamento exportAgendamento;

    @GetMapping("/{idUser}/{idAgendamento}/agendamento/info")
    public ResponseEntity<?> exportAgendamento(
            @PathVariable Integer idUser,
            @PathVariable Integer idAgendamento
    ){
        exportAgendamento.execute(idUser, idAgendamento);

        return null;
    }

}
