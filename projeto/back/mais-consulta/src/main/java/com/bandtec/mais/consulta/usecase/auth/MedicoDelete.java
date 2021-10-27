package com.bandtec.mais.consulta.usecase.auth;

import com.bandtec.mais.consulta.exception.DeleteException;
import org.springframework.http.ResponseEntity;

public interface MedicoDelete {
    ResponseEntity<?> execute(Integer id) throws DeleteException;
}
