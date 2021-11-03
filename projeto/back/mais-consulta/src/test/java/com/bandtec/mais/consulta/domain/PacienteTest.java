package com.bandtec.mais.consulta.domain;

import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.swing.text.html.Option;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
class PacienteTest {
    PacienteRepository pacienteRepository = Mockito.mock(PacienteRepository.class);

    @Test
    void teste() {
        Mockito.when(pacienteRepository.findById(1)).thenReturn(
                Optional.of(Paciente
                        .builder()
                        .nome("Luis")
                        .sexo("Masculino")
                        .build())
        );


        Optional<Paciente> paciente = pacienteRepository.findById(1);

        Assert.assertEquals(123L, paciente);
        Mockito.verify(pacienteRepository).findById(1);
    }

}