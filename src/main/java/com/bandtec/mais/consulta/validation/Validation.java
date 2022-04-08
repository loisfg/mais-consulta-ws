package com.bandtec.mais.consulta.validation;

public interface Validation {
    void verifyDoctorExists(Integer doctorId);

    void verifyPatient(Integer idPatient);
}
