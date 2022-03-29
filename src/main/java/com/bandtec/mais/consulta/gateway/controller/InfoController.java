package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.usecase.info.*;
import com.bandtec.mais.consulta.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
    @Autowired
    private Validation validation;

    @PostMapping("/alergia/{idUser}")
    public ResponseEntity<List<Alergia>> postAlergia(@PathVariable Integer idUser,
                                                      @RequestBody Iterable<Integer> alergia) {
        validation.verifyPatient(idUser);
        List<Alergia> alergias = postAlergia.execute(alergia, idUser);
        if (alergias.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(201).body(alergias);
    }

    @GetMapping("/alergias/{idUser}")
    public ResponseEntity<List<Alergia>> getAlergias(@PathVariable Integer idUser) {
        validation.verifyPatient(idUser);
        List<Alergia> alergiaList = getAlergia.execute(idUser);
        if (alergiaList.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(alergiaList);
    }

    @PutMapping("/{id}/alergia")
    public ResponseEntity<Alergia> putAlergia(@PathVariable Integer id,
                                              @RequestBody Alergia alergia) {
        validation.verifyPatient(id);
        Optional<Alergia> oAlergia = putAlergia.execute(id, alergia);
        return ResponseEntity.of(oAlergia);
    }

    @PostMapping("/remedio/{idUser}")
    public ResponseEntity<List<Remedio>> postRemedio(@PathVariable Integer idUser,
                                                    @RequestBody Iterable<Integer> remedio) {
        validation.verifyPatient(idUser);
        List<Remedio> remediosList = postRemedio.execute(remedio, idUser);
        if (!remediosList.isEmpty()) {
            return ResponseEntity.status(201).body(remediosList);
        }

        return ResponseEntity.status(204).build();
    }

    @GetMapping("/{idUser}/remedio")
    public ResponseEntity<List<Remedio>> getRemedios(@PathVariable Integer idUser) {
        validation.verifyPatient(idUser);
        List<Remedio> remedioList = getRemedio.execute(idUser);
        if (remedioList.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(remedioList);
    }

    @PutMapping("/{id}/remedio")
    public ResponseEntity<Remedio> putRemedio(@PathVariable Integer id,
                                              @RequestBody Remedio remedio) {
        validation.verifyPatient(id);
        Optional<Remedio> oRemedio = putRemedio.execute(id, remedio);
        return ResponseEntity.of(oRemedio);
    }

    @PostMapping("/deficiencia/{idUser}")
    public ResponseEntity<List<Deficiencia>> postDeficiencia(@PathVariable Integer idUser,
                                                            @RequestBody Iterable<Integer> deficiencia) {
        validation.verifyPatient(idUser);
        List<Deficiencia> deficienciaList = postDeficiencia.execute(deficiencia, idUser);

        if (!deficienciaList.isEmpty()) {
            return ResponseEntity.status(201).body(deficienciaList);
        }

        return ResponseEntity.status(204).build();
    }

    @GetMapping("/{idUser}/deficiencia")
    public ResponseEntity<List<Deficiencia>> getDeficiencias(@PathVariable Integer idUser) {
        validation.verifyPatient(idUser);
        List<Deficiencia> deficienciaList = getDeficiencia.execute(idUser);
        if (deficienciaList.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(deficienciaList);
    }

    @PutMapping("/{id}/deficiencia")
    public ResponseEntity<Deficiencia> putDeficiencia(@PathVariable Integer id,
                                                      @RequestBody Deficiencia deficiencia) {
        validation.verifyPatient(id);
        return ResponseEntity.of(putDeficiencia.execute(id, deficiencia));
    }

    @PostMapping("/doenca/{idUser}")
    public ResponseEntity<List<Doenca>> postDoenca(@PathVariable Integer idUser,
                                                  @RequestBody Iterable<Integer> doenca) {
        List<Doenca> doencas = postDoenca.execute(doenca, idUser);
        validation.verifyPatient(idUser);
        if (!doencas.isEmpty()) {
            return ResponseEntity.status(201).body(doencas);
        }

        return ResponseEntity.status(204).build();
    }

    @GetMapping("/{idUser}/doenca")
    public ResponseEntity<List<Doenca>> getDoenca(@PathVariable Integer idUser) {
        validation.verifyPatient(idUser);
        List<Doenca> doencaList = getDoenca.execute(idUser);
        if (doencaList.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(doencaList);
    }

    @PutMapping("/{id}/doenca")
    public ResponseEntity<Doenca> putDoenca(@PathVariable Integer id,
                                            @RequestBody Doenca doenca) {
        validation.verifyPatient(id);
        return ResponseEntity.of(putDoenca.execute(id, doenca));
    }

}
