package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.domain.Clinic;
import com.bandtec.mais.consulta.domain.Doctor;
import com.bandtec.mais.consulta.usecase.search.SearchClinic;
import com.bandtec.mais.consulta.usecase.search.SearchDistricts;
import com.bandtec.mais.consulta.usecase.search.SearchSpecialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("search")
public class SearchController {
    private final SearchSpecialty searchSpecialties;
    private final SearchClinic searchClinic;
    private final SearchDistricts searchDistricts;

    @Autowired
    public SearchController(
            SearchSpecialty searchSpecialties,
            SearchClinic searchClinic,
            SearchDistricts searchDistricts
    ) {
        this.searchSpecialties = searchSpecialties;
        this.searchClinic = searchClinic;
        this.searchDistricts = searchDistricts;
    }

    @GetMapping("/doctor/{specialty}/{district}")
    public ResponseEntity<List<Doctor>> getDoctorsSpecialties(@PathVariable String specialty,
                                                              @PathVariable String district) {
        List<Doctor> doctorList = searchSpecialties.execute(specialty, district);
        return doctorList.isEmpty() ?
                ResponseEntity.status(204).build() : ResponseEntity.status(200).body(doctorList);
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

    @GetMapping("/districts")
    public ResponseEntity<List<String>> getDistrictWithClinic() {
        List<String> districts = searchDistricts.execute();
        return districts.isEmpty() ?
                ResponseEntity.status(204).build() : ResponseEntity.status(200).body(districts);
    }
}