package com.bandtec.mais.consulta.controller;

import com.bandtec.mais.consulta.domain.Alergia;
import com.bandtec.mais.consulta.domain.Deficiencia;
import com.bandtec.mais.consulta.domain.Doenca;
import com.bandtec.mais.consulta.domain.Remedio;
import com.bandtec.mais.consulta.models.dto.ListaObj;
import com.bandtec.mais.consulta.usecase.userinfo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("infos")
public class UserInfoController {

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
    public UserInfoController(PostAlergia postAlergia, GetAlergia getAlergia, PutAlergia putAlergia, PostRemedio postRemedio, GetRemedio getRemedio, PutRemedio putRemedio, PostDeficiencia postDeficiencia, GetDeficiencia getDeficiencia, PutDeficiencia putDeficiencia, PostDoenca postDoenca, GetDoenca getDoenca, PutDoenca putDoenca) {
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

    //-----------POST/GET/PUT----- ALERGIA -----------POST/GET/PUT-----
    @PostMapping("/alergia")
    public ResponseEntity<Alergia> createAlergia(@RequestBody Alergia alergia) {
        return ResponseEntity.status(201).body(postAlergia.execute(alergia));
    }

    @GetMapping("/{idUser}/alergia")
    public ResponseEntity<ListaObj<Alergia>> getAlergias(@PathVariable Integer idUser) {
        ListaObj<Alergia> alergiaList = getAlergia.execute(idUser);
        if (alergiaList.estaVazia()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(alergiaList);
    }

    @PutMapping("/{id}/alergia")
    public ResponseEntity<Alergia> putAlergia(@PathVariable Integer id, @RequestBody Alergia alergia) {
        Optional<Alergia> oAlergia = putAlergia.execute(id, alergia);
        return ResponseEntity.of(oAlergia);
    }

    //-----------POST/GET/PUT----- REMEDIO-----------POST/GET/PUT-----
    @PostMapping("/remedio")
    public ResponseEntity<Remedio> postRemedio(@RequestBody Remedio remedio) {
        return ResponseEntity.status(201).body(postRemedio.execute(remedio));
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
    public ResponseEntity<Remedio> putRemedio(@PathVariable Integer id, @RequestBody Remedio remedio) {
        Optional<Remedio> oRemedio = putRemedio.execute(id, remedio);
        return ResponseEntity.of(oRemedio);
    }

    //-----------POST/GET/PUT----- DEFICIENCIA -----------POST/GET/PUT-----
    @PostMapping("/deficiencia")
    public ResponseEntity<Deficiencia> postDeficiencia(@RequestBody Deficiencia deficiencia) {
        return ResponseEntity.status(201).body(postDeficiencia.execute(deficiencia));
    }

    @GetMapping("/{idUser}/deficiencia")
    public ResponseEntity<List<Deficiencia>> getDeficiencias(
            @PathVariable Integer idUser
    ) {
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
    @PostMapping("/doenca")
    public ResponseEntity<Doenca> postDoenca(@RequestBody Doenca doenca) {
        return ResponseEntity.status(201).body(postDoenca.execute(doenca));
    }

    @GetMapping("/{idUser}/doenca")
    public ResponseEntity<List<Doenca>> getDoenca(
            @PathVariable Integer idUser
    ) {
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
