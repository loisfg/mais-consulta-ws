package com.bandtec.mais.consulta.usecase.email;

import com.bandtec.mais.consulta.domain.Email;
import com.bandtec.mais.consulta.models.dto.request.EmailDTO;

public interface EmailSend {
    Email execute(EmailDTO emailDTO, Integer id);
}
