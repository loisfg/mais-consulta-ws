package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.domain.Clinic;
import com.bandtec.mais.consulta.domain.Doctor;
import com.bandtec.mais.consulta.usecase.search.SearchClinic;
import com.bandtec.mais.consulta.usecase.search.SearchDistricts;
import com.bandtec.mais.consulta.usecase.search.SearchDoctor;
import com.bandtec.mais.consulta.usecase.search.SearchSpecialtyByDistrict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("search")
public class SearchController {
    private final SearchSpecialtyByDistrict searchSpecialtyByDistrict;
    private final SearchClinic searchClinic;
    private final SearchDistricts searchDistricts;
    private final SearchDoctor searchDoctor;

    @Autowired
    public SearchController(
            SearchSpecialtyByDistrict searchSpecialtyByDistrict,
            SearchClinic searchClinic,
            SearchDistricts searchDistricts,
            SearchDoctor searchDoctor
    ) {
        this.searchSpecialtyByDistrict = searchSpecialtyByDistrict;
        this.searchClinic = searchClinic;
        this.searchDistricts = searchDistricts;
        this.searchDoctor = searchDoctor;
    }

    @GetMapping("/doctor/{specialty}/{district}")
    public ResponseEntity<List<Doctor>> getDoctorsSpecialtiesAndDistrict(@PathVariable String specialty,
                                                              @PathVariable String district) {
        List<Doctor> doctorList = searchSpecialtyByDistrict.execute(specialty, district);
        return doctorList.isEmpty() ?
                ResponseEntity.status(204).build() : ResponseEntity.status(200).body(doctorList);
    }

    @GetMapping("/doctor/{specialty}")
    public ResponseEntity<List<Doctor>> getDoctorsSpecialties(@PathVariable String specialty) {
        List<Doctor> doctorList = searchDoctor.execute(specialty);
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