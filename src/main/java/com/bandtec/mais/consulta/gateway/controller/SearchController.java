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
    private final SearchEspecialidade searchEspecialidade;
    private final SearchUbs searchUbs;
    private final GetRemediosToComplet getRemediosToComplet;
    private final GetDeficienciaToComplet getDeficienciaToComplet;
    private final GetAlergiasToComplet getAlergiasToComplet;
    private final GetDstToComplet getDstToComplet;
    private final GetDoencaCronicaToComplet getDoencasCronicasToComplet;

    @Autowired
    public SearchController(SearchEspecialidade searchEspecialidade, SearchUbs searchUbs, GetRemediosToComplet getRemediosToComplet, GetDeficienciaToComplet getDeficienciaToComplet, GetAlergiasToComplet getAlergiasToComplet, GetDstToComplet getDstToComplet, GetDoencaCronicaToComplet getDoencasCronicasToComplet) {
        this.searchEspecialidade = searchEspecialidade;
        this.searchUbs = searchUbs;
        this.getRemediosToComplet = getRemediosToComplet;
        this.getDeficienciaToComplet = getDeficienciaToComplet;
        this.getAlergiasToComplet = getAlergiasToComplet;
        this.getDstToComplet = getDstToComplet;
        this.getDoencasCronicasToComplet = getDoencasCronicasToComplet;
    }

    @GetMapping("/{especialidade}")
    public ResponseEntity<Set<Doctor>> getMedicosEspecialidade(@PathVariable String especialidade) {
        return searchEspecialidade.execute(especialidade).isEmpty() ?
                ResponseEntity.status(204).build() : ResponseEntity.status(200).body(
                        (searchEspecialidade.execute(especialidade))
        );
    }

    @GetMapping("/ubs/{idEspecialidade}")
    public ResponseEntity<List<Ubs>> getUbs(@PathVariable Integer idEspecialidade) {
        List<Ubs> ubs = searchUbs.execute(idEspecialidade);
        return ubs.isEmpty() ?
                ResponseEntity.status(204).build() : ResponseEntity.status(200).body(ubs);
    }

    @GetMapping("/remedios/auto/{nome}")
    public ResponseEntity<Set<Medicine>> getRemediosAuto(@PathVariable String nome) {
        return ResponseEntity.of(getRemediosToComplet.execute(nome));
    }

    @GetMapping("/alergias/auto/{nome}")
    public ResponseEntity<Set<Allergy>> getAlergiaAuto(@PathVariable String nome) {
        return ResponseEntity.of(getAlergiasToComplet.execute(nome));
    }

    @GetMapping("/deficiencias/auto/{nome}")
    public ResponseEntity<Set<Deficiency>> getDeficienciaAuto(@PathVariable String nome) {
        return ResponseEntity.of(getDeficienciaToComplet.execute(nome));
    }

    @GetMapping("/doencas-cronicas/auto/{nome}")
    public ResponseEntity<Set<InfoResponseDTO>> getDoencaCronicaAuto(@PathVariable String nome) {
        return ResponseEntity.of(getDoencasCronicasToComplet.execute(nome));
    }

    @GetMapping("/dst/auto/{nome}")
    public ResponseEntity<Set<InfoResponseDTO>> getDstAuto(@PathVariable String nome) {
        return ResponseEntity.of(getDstToComplet.execute(nome));
    }
}