package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.usecase.search.SearchSpecialty;
import com.bandtec.mais.consulta.usecase.search.SearchClinic;
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
    private final SearchClinic searchClinic;

    @Autowired
    public SearchController(SearchSpecialty searchSpecialties,
                            SearchClinic searchClinic) {
        this.searchSpecialties = searchSpecialties;
        this.searchClinic = searchClinic;
    }

    @GetMapping("/{specialty}")
    public ResponseEntity<Set<Doctor>> getDoctorsSpecialties(@PathVariable String specialty) {
        return searchSpecialties.execute(specialty).isEmpty() ?
                ResponseEntity.status(204).build() : ResponseEntity.status(200).body(
                (searchSpecialties.execute(specialty))
        );
    }

    @GetMapping("/clinica/{specialtyId}")
    public ResponseEntity<List<Clinic>> getClinicBySpeciality(@PathVariable Integer specialtyId) {
        List<Clinic> clinic = searchClinic.execute(specialtyId);
        return clinic.isEmpty() ?
                ResponseEntity.status(204).build() : ResponseEntity.status(200).body(clinic);
    }

    @GetMapping("/clinicas/{district}")
    public ResponseEntity<List<Clinic>> getClinicByDistrict(@PathVariable String district) {
        List<Clinic> clinic = searchClinic.execute(district);
        return clinic.isEmpty() ?
                ResponseEntity.status(204).build() : ResponseEntity.status(200).body(clinic);
    }
}