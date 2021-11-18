package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.models.dto.request.UbsPostRequestDTO;
import com.bandtec.mais.consulta.usecase.ubs.PostUbs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ubs")
public class UbsController {

    @Autowired
    private PostUbs postUbs;

    @PostMapping
    public ResponseEntity<?> postUbs(@RequestBody UbsPostRequestDTO ubsPostRequestDTO){
        return ResponseEntity.of(postUbs.execute(ubsPostRequestDTO));
    }

}
