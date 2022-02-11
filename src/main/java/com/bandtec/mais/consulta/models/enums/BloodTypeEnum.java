package com.bandtec.mais.consulta.models.enums;

public enum BloodTypeEnum {
    A_POSITIVO("A+"),
    A_NEGATIVO("A-"),
    B_POSITIVO("B+"),
    B_NEGATIVO("B-"),
    AB_POSITIVO("AB+"),
    AB_NEGATIVO("AB-"),
    O_POSITIVO("O+"),
    O("O"),
    DEFAULT("");

    private String tipoSanguineo;

    BloodTypeEnum(final String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }
}
