package com.bandtec.mais.consulta.usecase.auth;

import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.models.dto.request.UsuarioSignInRequestDTO;
import com.bandtec.mais.consulta.models.dto.response.MedicoSignInResponseDTO;
import com.bandtec.mais.consulta.models.dto.response.PacienteSignInResponseDTO;

import java.util.List;
import java.util.Optional;

public interface MedicoSignIn {
    Optional<MedicoSignInResponseDTO> execute(UsuarioSignInRequestDTO usuarioSignInRequestDTO, List<Usuario> usuariosLogados);
}