package com.bandtec.mais.consulta.validation;

public interface Validation {
    void verifyMedicoExists(Integer idmedico);
    void verifyPatient(Integer idPatient);
}
