package com.bandtec.mais.consulta.controller;

import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.usecase.search.SearchEspecialidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("search")
public class SearchController {
    private final SearchEspecialidade searchEspecialidade;

    @Autowired
    public SearchController(SearchEspecialidade searchEspecialidade) {
        this.searchEspecialidade = searchEspecialidade;
    }

    // Busca por especialidade
    @GetMapping("/{especialidade}")
    public ResponseEntity<Set<Medico>> getMedicosEspecialidade(@PathVariable String especialidade) {
        if(searchEspecialidade.execute(especialidade).isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(
                (searchEspecialidade.execute(especialidade))
        );
    }
}
