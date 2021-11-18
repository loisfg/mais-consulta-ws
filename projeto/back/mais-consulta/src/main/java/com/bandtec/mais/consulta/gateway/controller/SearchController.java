package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.domain.Ubs;
import com.bandtec.mais.consulta.usecase.search.SearchEspecialidade;
import com.bandtec.mais.consulta.usecase.search.SearchUbs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("search")
public class SearchController {
    private final SearchEspecialidade searchEspecialidade;
    private final SearchUbs searchUbs;

    @Autowired
    public SearchController(SearchEspecialidade searchEspecialidade, SearchUbs searchUbs) {
        this.searchEspecialidade = searchEspecialidade;
        this.searchUbs = searchUbs;
    }

    @GetMapping("/{especialidade}")
    public ResponseEntity<Set<Medico>> getMedicosEspecialidade(@PathVariable String especialidade) {
        return searchEspecialidade.execute(especialidade).isEmpty() ?
                ResponseEntity.status(204).build() : ResponseEntity.status(200).body(
                        (searchEspecialidade.execute(especialidade))
        );
    }

    @GetMapping("/ubs")
    public ResponseEntity<List<Ubs>> getUbs() {
        List<Ubs> ubs = searchUbs.execute();
        return ubs.isEmpty() ?
                ResponseEntity.status(204).build() : ResponseEntity.status(200).body(ubs);
    }
}
