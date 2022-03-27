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

    private final PostAllergy postAllergy;
    private final GetAllergy getAllergy;
    private final PutAllergy putAllergy;

    private final PostMedicine postMedicine;
    private final GetMedicine getMedicine;
    private final PutMedicine putMedicine;

    private final PostDeficiency postDeficiencies;
    private final GetDeficiency getDeficiencies;
    private final PutDeficiency putDeficiencies;

    private final PostDisease postDiseases;
    private final GetDisease getDiseases;
    private final PutDisease putDiseases;

    @Autowired
    public InfoController(PostAllergy postAllergy,
                          GetAllergy getAllergy,
                          PutAllergy putAllergy,
                          PostMedicine postMedicine,
                          GetMedicine getMedicine,
                          PutMedicine putMedicine,
                          PostDeficiency postDeficiencies,
                          GetDeficiency getDeficiencies,
                          PutDeficiency putDeficiencies,
                          PostDisease postDiseases,
                          GetDisease getDiseases,
                          PutDisease putDiseases) {
        this.postAllergy = postAllergy;
        this.getAllergy = getAllergy;
        this.putAllergy = putAllergy;
        this.postMedicine = postMedicine;
        this.getMedicine = getMedicine;
        this.putMedicine = putMedicine;
        this.postDeficiencies = postDeficiencies;
        this.getDeficiencies = getDeficiencies;
        this.putDeficiencies = putDeficiencies;
        this.postDiseases = postDiseases;
        this.getDiseases = getDiseases;
        this.putDiseases = putDiseases;
    }

    @PostMapping("/alergia/{idUser}")
    public ResponseEntity<List<Allergy>> postAllergy(@PathVariable Integer userId,
                                                     @RequestBody Iterable<Integer> allergy) {

        List<Allergy> allergies = postAllergy.execute(allergy, userId);
        if (allergies.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(201).body(allergies);
    }

    @GetMapping("/alergias/{idUser}")
    public ResponseEntity<List<Allergy>> getAllergies(@PathVariable Integer userId) {
        List<Allergy> allergyList = getAllergy.execute(userId);
        if (allergyList.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(allergyList);
    }

    @PutMapping("/{id}/alergia")
    public ResponseEntity<Allergy> putAllergy(@PathVariable Integer id,
                                              @RequestBody Allergy allergy) {
        Optional<Allergy> oAllergy = putAllergy.execute(id, allergy);
        return ResponseEntity.of(oAllergy);
    }

    @PostMapping("/remedio/{idUser}")
    public ResponseEntity<List<Medicine>> postMedicine(@PathVariable Integer userId,
                                                       @RequestBody Iterable<Integer> medicine) {

        List<Medicine> medicineList = postMedicine.execute(medicine, userId);
        if (!medicineList.isEmpty()) {
            return ResponseEntity.status(201).body(medicineList);
        }

        return ResponseEntity.status(204).build();
    }

    @GetMapping("/{idUser}/remedio")
    public ResponseEntity<List<Medicine>> getMedicines(@PathVariable Integer userId) {
        List<Medicine> medicineList = getMedicine.execute(userId);
        if (medicineList.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(medicineList);
    }

    @PutMapping("/{id}/remedio")
    public ResponseEntity<Medicine> putMedicine(@PathVariable Integer id,
                                                @RequestBody Medicine medicine) {
        Optional<Medicine> oMedicine = putMedicine.execute(id, medicine);
        return ResponseEntity.of(oMedicine);
    }

    @PostMapping("/deficiencia/{idUser}")
    public ResponseEntity<List<Deficiency>> postDeficiencies(@PathVariable Integer idUser,
                                                             @RequestBody Iterable<Integer> deficiency) {
        List<Deficiency> deficiencyList = postDeficiencies.execute(deficiency, idUser);

        if (!deficiencyList.isEmpty()) {
            return ResponseEntity.status(201).body(deficiencyList);
        }

        return ResponseEntity.status(204).build();
    }

    @GetMapping("/{idUser}/deficiencia")
    public ResponseEntity<List<Deficiency>> getDeficiencies(@PathVariable Integer userId) {
        List<Deficiency> deficiencyList = getDeficiencies.execute(userId);
        if (deficiencyList.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(deficiencyList);
    }

    @PutMapping("/{id}/deficiencia")
    public ResponseEntity<Deficiency> putDeficiency(@PathVariable Integer id,
                                                    @RequestBody Deficiency deficiency) {
        return ResponseEntity.of(putDeficiencies.execute(id, deficiency));
    }

    @PostMapping("/doenca/{idUser}")
    public ResponseEntity<List<Disease>> postDisease(@PathVariable Integer userId,
                                                     @RequestBody Iterable<Integer> disease) {
        List<Disease> diseases = postDiseases.execute(disease, userId);

        if (!diseases.isEmpty()) {
            return ResponseEntity.status(201).body(diseases);
        }

        return ResponseEntity.status(204).build();
    }

    @GetMapping("/{idUser}/doenca")
    public ResponseEntity<List<Disease>> getDisease(@PathVariable Integer userId) {
        List<Disease> diseaseList = getDiseases.execute(userId);
        if (diseaseList.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(diseaseList);
    }

    @PutMapping("/{id}/doenca")
    public ResponseEntity<Disease> putDisease(@PathVariable Integer id,
                                              @RequestBody Disease disease) {
        return ResponseEntity.of(putDiseases.execute(id, disease));
    }

}
