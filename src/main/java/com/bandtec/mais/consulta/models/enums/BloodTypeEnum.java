package com.bandtec.mais.consulta.models.enums;

public enum BloodTypeEnum {
    A_POSITIVE("A+"),
    A_NEGATIVE("A-"),
    B_POSITIVE("B+"),
    B_NEGATIVE("B-"),
    AB_POSITIVE("AB+"),
    AB_NEGATIVE("AB-"),
    O_POSITIVE("O+"),
    O("O"),
    DEFAULT("");

    private String bloodType;

    BloodTypeEnum(final String bloodType) {
        this.bloodType = bloodType;
    }
}
