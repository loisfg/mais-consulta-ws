package com.bandtec.mais.consulta.usecase.userinfo;

import com.bandtec.mais.consulta.domain.Deficiencia;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface PutDeficiencia {
    Optional<Deficiencia> execute(Integer id, Deficiencia deficiencia);
}
