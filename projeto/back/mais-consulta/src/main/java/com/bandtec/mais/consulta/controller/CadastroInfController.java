package com.bandtec.mais.consulta.controller;

import com.bandtec.mais.consulta.domain.Alergia;
import com.bandtec.mais.consulta.domain.Deficiencia;
import com.bandtec.mais.consulta.domain.Doenca;
import com.bandtec.mais.consulta.domain.Remedio;
import com.bandtec.mais.consulta.gateway.database.repository.AlergiaRepository;
import com.bandtec.mais.consulta.gateway.database.repository.DeficienciaRepository;
import com.bandtec.mais.consulta.gateway.database.repository.DoencaRepository;
import com.bandtec.mais.consulta.gateway.database.repository.RemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/info")
public class CadastroInfController {

    @Autowired
    private AlergiaRepository bancoAlergia;

    @Autowired
    private RemedioRepository bancoRemedio;

    @Autowired
    private DoencaRepository bancoDoenca;

    @Autowired
    private DeficienciaRepository bancoDeficiencia;

    @PostMapping("/deficiencia")
    public ResponseEntity postDeficiencia(@RequestBody Deficiencia deficiencia){
        System.out.println(deficiencia);
        bancoDeficiencia.save(deficiencia);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/deficiencia")
    public ResponseEntity getDeficiencia(){
        List<Deficiencia> deficienciaList=bancoDeficiencia.findAll();
        if (deficienciaList.isEmpty()){
            return  ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(deficienciaList);
    }

    @PutMapping("/deficiencia/{id}")
    public ResponseEntity putDoenca(@PathVariable Integer id,
                                    @RequestBody Deficiencia deficienciaAlterado) {
        if (bancoDeficiencia.existsById(id)) {
            deficienciaAlterado.setId(id);
            bancoDeficiencia.save(deficienciaAlterado);
            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
    }

    //-----------POST/GET/PUT----- REMEDIO-----------POST/GET/PUT-----
    @PostMapping("/doenca")
    public ResponseEntity postDoenca(@RequestBody Doenca doenca){
        System.out.println(doenca);
        bancoDoenca.save(doenca);
        return ResponseEntity.status(201).build();
    }
    @GetMapping("/doenca")
    public ResponseEntity getDoenca(){
        List<Doenca> doencaList=bancoDoenca.findAll();
        if (doencaList.isEmpty()){
            return  ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(doencaList);
    }
    @PutMapping("/doenca/{id}")
    public ResponseEntity putDoenca(@PathVariable Integer id,
                                     @RequestBody Doenca doencaAlterada) {
        if (bancoDoenca.existsById(id)) {
            doencaAlterada.setId(id);
            bancoDoenca.save(doencaAlterada);
            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
    }

    //-----------POST/GET/PUT----- REMEDIO-----------POST/GET/PUT-----
    @PostMapping("/remedio")
    public ResponseEntity postRemedio(@RequestBody Remedio remedio){
        System.out.println(remedio);
        bancoRemedio.save(remedio);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/remedio")
    public ResponseEntity getRemedio(){
        List<Remedio> remedioList=bancoRemedio.findAll();
        if (remedioList.isEmpty()){
            return  ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(remedioList);
    }
    @PutMapping("/remedio/{id}")
    public ResponseEntity putRemedio(@PathVariable Integer id,
                                     @RequestBody Remedio remedioMudado) {
        if (bancoRemedio.existsById(id)) {
            remedioMudado.setId(id);
            bancoRemedio.save(remedioMudado);
            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
    }

    //-----------POST/GET/PUT----- ALERGIA-----------POST/GET/PUT-----
    @PostMapping("/alergia")
    public ResponseEntity postAlergia(@RequestBody Alergia alerg){
        System.out.println(alerg);
        bancoAlergia.save(alerg);

        return ResponseEntity.status(201).build();

    }

    @GetMapping("/alergia")
    public ResponseEntity getAlergia(){
        List<Alergia> alergiaList= bancoAlergia.findAll();
        if (alergiaList.isEmpty()){
            return  ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(alergiaList);
    }
    @PutMapping("/alergia/{id}")
    public ResponseEntity putAlergia(@PathVariable Integer id,
                                      @RequestBody Alergia alergiaAlterada) {
        if (bancoAlergia.existsById(id)) {
            alergiaAlterada.setId(id);
            bancoAlergia.save(alergiaAlterada);
            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
    }

}
