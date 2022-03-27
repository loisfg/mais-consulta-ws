package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.models.dto.response.InfoResponseDTO;
import com.bandtec.mais.consulta.usecase.info.*;
import com.bandtec.mais.consulta.usecase.search.SearchEspecialidade;
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
    private final SearchEspecialidade searchSpecialties;
    private final SearchUbs searchUbs;
    private final GetMedicinesToComplete getMedicinesToComplete;
    private final GetDeficiencyToComplete getDeficienciesToComplete;
    private final GetAllergiesToComplete getAllergiesToComplete;
    private final GetStdsToComplete getStdsToComplete;
    private final GetChronicDiseaseToComplete getChronicDiseasesToComplete;

    @Autowired
    public SearchController(SearchEspecialidade searchSpecialties,
                            SearchUbs searchUbs,
                            GetMedicinesToComplete getMedicinesToComplete,
                            GetDeficiencyToComplete getDeficienciesToComplete,
                            GetAllergiesToComplete getAllergiesToComplete,
                            GetStdsToComplete getStdsToComplete,
                            GetChronicDiseaseToComplete getChronicDiseasesToComplete) {
        this.searchSpecialties = searchSpecialties;
        this.searchUbs = searchUbs;
        this.getMedicinesToComplete = getMedicinesToComplete;
        this.getDeficienciesToComplete = getDeficienciesToComplete;
        this.getAllergiesToComplete = getAllergiesToComplete;
        this.getStdsToComplete = getStdsToComplete;
        this.getChronicDiseasesToComplete = getChronicDiseasesToComplete;
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

    @GetMapping("/remedios/auto/{nome}")
    public ResponseEntity<Set<Medicine>> getAutoMedicines(@PathVariable String name) {
        return ResponseEntity.of(getMedicinesToComplete.execute(name));
    }

    @GetMapping("/alergias/auto/{nome}")
    public ResponseEntity<Set<Allergy>> getAutoAllergies(@PathVariable String name) {
        return ResponseEntity.of(getAllergiesToComplete.execute(name));
    }

    @GetMapping("/deficiencias/auto/{nome}")
    public ResponseEntity<Set<Deficiency>> getAutoDeficiency(@PathVariable String name) {
        return ResponseEntity.of(getDeficienciesToComplete.execute(name));
    }

    @GetMapping("/doencas-cronicas/auto/{nome}")
    public ResponseEntity<Set<InfoResponseDTO>> getAutoChronicDisease(@PathVariable String name) {
        return ResponseEntity.of(getChronicDiseasesToComplete.execute(name));
    }

    @GetMapping("/dst/auto/{nome}")
    public ResponseEntity<Set<InfoResponseDTO>> getAutoStds(@PathVariable String name) {
        return ResponseEntity.of(getStdsToComplete.execute(name));
    }
}