package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.usecase.info.*;
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
    private final PostSameRemedio postSameRemedio;
    private final GetRemediosToComplet getRemediosToComplet;

    private final PostDeficiencia postDeficiencia;
    private final GetDeficiencia getDeficiencia;
    private final PutDeficiencia putDeficiencia;

    private final PostDoenca postDoenca;
    private final GetDoenca getDoenca;
    private final PutDoenca putDoenca;

    @Autowired
    public InfoController(PostAlergia postAlergia, GetAlergia getAlergia, PutAlergia putAlergia, PostRemedio postRemedio, GetRemedio getRemedio, PutRemedio putRemedio, PostSameRemedio postSameRemedio, GetRemediosToComplet getRemediosToComplet, PostDeficiencia postDeficiencia, GetDeficiencia getDeficiencia, PutDeficiencia putDeficiencia, PostDoenca postDoenca, GetDoenca getDoenca, PutDoenca putDoenca) {
        this.postAlergia = postAlergia;
        this.getAlergia = getAlergia;
        this.putAlergia = putAlergia;
        this.postRemedio = postRemedio;
        this.getRemedio = getRemedio;
        this.putRemedio = putRemedio;
        this.postSameRemedio = postSameRemedio;
        this.getRemediosToComplet = getRemediosToComplet;
        this.postDeficiencia = postDeficiencia;
        this.getDeficiencia = getDeficiencia;
        this.putDeficiencia = putDeficiencia;
        this.postDoenca = postDoenca;
        this.getDoenca = getDoenca;
        this.putDoenca = putDoenca;
    }

    //-----------POST/GET/PUT----- ALERGIA -----------POST/GET/PUT-----
    @PostMapping("/alergia/{idUser}")
    public ResponseEntity<Set<Alergia>> createAlergia(@PathVariable Integer idUser,
                                                      @RequestBody Iterable<Integer> alergia) {

        List<Alergia> alergias = postAlergia.execute(alergia, idUser);
        if (alergias.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(201).body(new HashSet<>(alergias));
    }

    @GetMapping("/alergias/{idUser}")
    public ResponseEntity<List<Alergia>> getAlergias(@PathVariable Integer idUser) {
        List<Alergia> alergiaList = getAlergia.execute(idUser);
        if (alergiaList.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(alergiaList);
    }

    @PutMapping("/{id}/alergia")
    public ResponseEntity<Alergia> putAlergia(@PathVariable Integer id,
                                              @RequestBody Alergia alergia) {
        Optional<Alergia> oAlergia = putAlergia.execute(id, alergia);
        return ResponseEntity.of(oAlergia);
    }

    //-----------POST/GET/PUT----- REMEDIO-----------POST/GET/PUT-----
    @PostMapping("/remedio/{idUser}")
    public ResponseEntity<Set<Remedio>> postRemedio(@PathVariable Integer idUser,
                                                    @RequestBody Iterable<Integer> remedio) {
        if (postRemedio.execute(remedio, idUser).isPresent()) {
            return ResponseEntity.status(201).build();
        }

        return ResponseEntity.status(204).build();
    }

    @PostMapping("/remedio/add")
    public ResponseEntity postRemedios() {
        postSameRemedio.execute();

        return ResponseEntity.status(204).build();
    }

    @GetMapping("/remedios/auto/{nome}")
    public Set<Remedio> getRemediosToAuto(@PathVariable String nome) {
        return getRemediosToComplet.execute(nome);
    }

    @GetMapping("/{idUser}/remedio")
    public ResponseEntity<List<Remedio>> getRemedios(@PathVariable Integer idUser) {
        List<Remedio> remedioList = getRemedio.execute(idUser);
        if (remedioList.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(remedioList);
    }

    @PutMapping("/{id}/remedio")
    public ResponseEntity<Remedio> putRemedio(@PathVariable Integer id,
                                              @RequestBody Remedio remedio) {
        Optional<Remedio> oRemedio = putRemedio.execute(id, remedio);
        return ResponseEntity.of(oRemedio);
    }

    //-----------POST/GET/PUT----- DEFICIENCIA -----------POST/GET/PUT-----
    @PostMapping("/deficiencia/{idUser}")
    public ResponseEntity<Set<Deficiencia>> postDeficiencia(@PathVariable Integer idUser,
                                                            @RequestBody Iterable<Integer> deficiencia) {
        if (postDeficiencia.execute(deficiencia, idUser).isPresent()) {
            return ResponseEntity.status(201).build();
        }

        return ResponseEntity.status(204).build();
    }

    @GetMapping("/{idUser}/deficiencia")
    public ResponseEntity<List<Deficiencia>> getDeficiencias(@PathVariable Integer idUser) {
        List<Deficiencia> deficienciaList = getDeficiencia.execute(idUser);
        if (deficienciaList.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(deficienciaList);
    }

    @PutMapping("/{id}/deficiencia")
    public ResponseEntity<Deficiencia> putDeficiencia(@PathVariable Integer id,
                                                      @RequestBody Deficiencia deficiencia) {

        Optional<Deficiencia> oDeficiencia = putDeficiencia.execute(id, deficiencia);
        return ResponseEntity.of(oDeficiencia);
    }

    //-----------POST/GET/PUT----- DOENCA -----------POST/GET/PUT-----
    @PostMapping("/doenca/{idUser}")
    public ResponseEntity<Set<Doenca>> postDoenca(@PathVariable Integer idUser,
                                                  @RequestBody Iterable<Integer> doenca) {
        if (postDoenca.execute(doenca, idUser).isPresent()) {
            return ResponseEntity.status(201).build();
        }

        return ResponseEntity.status(204).build();
    }

    @GetMapping("/{idUser}/doenca")
    public ResponseEntity<List<Doenca>> getDoenca(@PathVariable Integer idUser) {
        List<Doenca> doencaList = getDoenca.execute(idUser);
        if (doencaList.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(doencaList);
    }

    @PutMapping("/{id}/doenca")
    public ResponseEntity<Doenca> putDoenca(@PathVariable Integer id,
                                            @RequestBody Doenca doenca) {
        return ResponseEntity.of(putDoenca.execute(id, doenca));
    }

}
