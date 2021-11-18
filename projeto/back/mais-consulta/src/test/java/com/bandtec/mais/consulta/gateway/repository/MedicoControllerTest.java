package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.gateway.controller.MedicoController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;




import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MedicoControllerTest {


    @Autowired
    MedicoController controller;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();

    }
}
