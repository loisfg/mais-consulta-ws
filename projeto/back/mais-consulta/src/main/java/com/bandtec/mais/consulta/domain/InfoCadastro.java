package com.bandtec.mais.consulta.domain;

import java.util.List;

public class InfoCadastro {

    List<Alergia> alergias;
    List<Doenca> doenca;
    List<Deficiencia> deficiencias;
    List<Remedio> remedios;

    public InfoCadastro(List<Alergia> alergias) {
        this.alergias = alergias;
    }
}
