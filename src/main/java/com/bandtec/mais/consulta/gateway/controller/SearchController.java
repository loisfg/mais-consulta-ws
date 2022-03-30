package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.usecase.search.SearchSpecialty;
import com.bandtec.mais.consulta.usecase.search.SearchUbs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("search")
public class SearchController {
    private final SearchSpecialty searchSpecialties;
    private final SearchUbs searchUbs;

    @Autowired
    public SearchController(SearchSpecialty searchSpecialties,
                            SearchUbs searchUbs) {
        this.searchSpecialties = searchSpecialties;
        this.searchUbs = searchUbs;
    }

    @GetMapping("/{especialidade}")
    public ResponseEntity<Set<Doctor>> getDoctorsSpecialties(@PathVariable String specialty) {
        return searchSpecialties.execute(specialty).isEmpty() ?
                ResponseEntity.status(204).build() : ResponseEntity.status(200).body(
                (searchSpecialties.execute(specialty))
        );
    }

    @GetMapping("/ubs/{idEspecialidade}")
    public ResponseEntity<List<Ubs>> getUbs(@PathVariable Integer specialtyId) {
        List<Ubs> ubs = searchUbs.execute(specialtyId);
        return ubs.isEmpty() ?
                ResponseEntity.status(204).build() : ResponseEntity.status(200).body(ubs);
    }
}