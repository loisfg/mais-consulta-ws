package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.usecase.info.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("infos")
public class InfoController {

    private final PostAlergia postAlergia;
    private final GetAlergia getAlergia;
    private final PutAlergia putAlergia;

    private final PostRemedio postRemedio;
    private final GetRemedio getRemedio;
    private final PutRemedio putRemedio;

    private final PostDeficiencia postDeficiencia;
    private final GetDeficiencia getDeficiencia;
    private final PutDeficiencia putDeficiencia;

    private final PostDoenca postDoenca;
    private final GetDoenca getDoenca;
    private final PutDoenca putDoenca;

    @Autowired
    public InfoController(PostAlergia postAlergia, GetAlergia getAlergia, PutAlergia putAlergia, PostRemedio postRemedio, GetRemedio getRemedio, PutRemedio putRemedio, PostDeficiencia postDeficiencia, GetDeficiencia getDeficiencia, PutDeficiencia putDeficiencia, PostDoenca postDoenca, GetDoenca getDoenca, PutDoenca putDoenca) {
        this.postAlergia = postAlergia;
        this.getAlergia = getAlergia;
        this.putAlergia = putAlergia;
        this.postRemedio = postRemedio;
        this.getRemedio = getRemedio;
        this.putRemedio = putRemedio;
        this.postDeficiencia = postDeficiencia;
        this.getDeficiencia = getDeficiencia;
        this.putDeficiencia = putDeficiencia;
        this.postDoenca = postDoenca;
        this.getDoenca = getDoenca;
        this.putDoenca = putDoenca;
    }

    @PostMapping("/alergia/{idUser}")
    public ResponseEntity<List<Allergy>> postAlergia(@PathVariable Integer idUser,
                                                     @RequestBody Iterable<Integer> alergia) {

        List<Allergy> allergies = postAlergia.execute(alergia, idUser);
        if (allergies.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(201).body(allergies);
    }

    @GetMapping("/alergias/{idUser}")
    public ResponseEntity<List<Allergy>> getAlergias(@PathVariable Integer idUser) {
        List<Allergy> allergyList = getAlergia.execute(idUser);
        if (allergyList.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(allergyList);
    }

    @PutMapping("/{id}/alergia")
    public ResponseEntity<Allergy> putAlergia(@PathVariable Integer id,
                                              @RequestBody Allergy allergy) {
        Optional<Allergy> oAlergia = putAlergia.execute(id, allergy);
        return ResponseEntity.of(oAlergia);
    }

    @PostMapping("/remedio/{idUser}")
    public ResponseEntity<List<Medicine>> postRemedio(@PathVariable Integer idUser,
                                                      @RequestBody Iterable<Integer> remedio) {

        List<Medicine> remediosList = postRemedio.execute(remedio, idUser);
        if (!remediosList.isEmpty()) {
            return ResponseEntity.status(201).body(remediosList);
        }

        return ResponseEntity.status(204).build();
    }

    @GetMapping("/{idUser}/remedio")
    public ResponseEntity<List<Medicine>> getRemedios(@PathVariable Integer idUser) {
        List<Medicine> medicineList = getRemedio.execute(idUser);
        if (medicineList.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(medicineList);
    }

    @PutMapping("/{id}/remedio")
    public ResponseEntity<Medicine> putRemedio(@PathVariable Integer id,
                                               @RequestBody Medicine medicine) {
        Optional<Medicine> oRemedio = putRemedio.execute(id, medicine);
        return ResponseEntity.of(oRemedio);
    }

    @PostMapping("/deficiencia/{idUser}")
    public ResponseEntity<List<Deficiency>> postDeficiencia(@PathVariable Integer idUser,
                                                            @RequestBody Iterable<Integer> deficiencia) {
        List<Deficiency> deficiencyList = postDeficiencia.execute(deficiencia, idUser);

        if (!deficiencyList.isEmpty()) {
            return ResponseEntity.status(201).body(deficiencyList);
        }

        return ResponseEntity.status(204).build();
    }

    @GetMapping("/{idUser}/deficiencia")
    public ResponseEntity<List<Deficiency>> getDeficiencias(@PathVariable Integer idUser) {
        List<Deficiency> deficiencyList = getDeficiencia.execute(idUser);
        if (deficiencyList.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(deficiencyList);
    }

    @PutMapping("/{id}/deficiencia")
    public ResponseEntity<Deficiency> putDeficiencia(@PathVariable Integer id,
                                                     @RequestBody Deficiency deficiency) {
        return ResponseEntity.of(putDeficiencia.execute(id, deficiency));
    }

    @PostMapping("/doenca/{idUser}")
    public ResponseEntity<List<Disease>> postDoenca(@PathVariable Integer idUser,
                                                    @RequestBody Iterable<Integer> doenca) {
        List<Disease> diseases = postDoenca.execute(doenca, idUser);

        if (!diseases.isEmpty()) {
            return ResponseEntity.status(201).body(diseases);
        }

        return ResponseEntity.status(204).build();
    }

    @GetMapping("/{idUser}/doenca")
    public ResponseEntity<List<Disease>> getDoenca(@PathVariable Integer idUser) {
        List<Disease> diseaseList = getDoenca.execute(idUser);
        if (diseaseList.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(diseaseList);
    }

    @PutMapping("/{id}/doenca")
    public ResponseEntity<Disease> putDoenca(@PathVariable Integer id,
                                             @RequestBody Disease disease) {
        return ResponseEntity.of(putDoenca.execute(id, disease));
    }

}
