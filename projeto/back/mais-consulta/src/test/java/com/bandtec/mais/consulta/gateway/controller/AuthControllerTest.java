package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.gateway.repository.UsuarioRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest()
class AuthControllerTest {

    @Autowired
    AuthController controller;

    @MockBean
    UsuarioRepository repository;

    @Test
    @DisplayName("Logar usuário tipo Paciente")
    void loginPatient_loginUserPatient() {
//        when(repository.findByCpfAndPassword()).thenReturn();
//        ResponseEntity<?> resp = controller.signin();

    }
}