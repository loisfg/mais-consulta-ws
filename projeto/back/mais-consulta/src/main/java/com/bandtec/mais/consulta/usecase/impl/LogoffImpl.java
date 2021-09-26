package com.bandtec.mais.consulta.usecase.impl;

import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.models.dto.request.UsuarioRequestDTO;
import com.bandtec.mais.consulta.usecase.Logoff;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogoffImpl implements Logoff {
    @Override
    public String execute(UsuarioRequestDTO usuarioRequestDTO, List<Usuario> usuariosLogados) {

        Optional<Object> oRemove = usuariosLogados.stream()
                .filter(it -> it.getCpf().equals(usuarioRequestDTO.getCpf()))
                .findFirst()
                .map(usuariosLogados::remove);

        return oRemove.isPresent() ? "sessão encerrada" : "sessão não encontrada";
    }
}
