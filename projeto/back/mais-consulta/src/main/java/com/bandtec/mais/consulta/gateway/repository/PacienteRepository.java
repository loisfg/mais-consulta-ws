package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Paciente;
import com.bandtec.mais.consulta.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    List<Paciente> findByNomeContaining(String nome);

    List<Paciente> findByEnderecoBairro(String bairro);

    Optional<Paciente> findByUsuarioCpfAndUsuarioPassword(String cpf, String password);

    boolean existsByUsuarioCpf(String cpf);

    boolean existsByEnderecoCidade(String cidade);

    Optional<Paciente> findByUsuario(Usuario usuario);

    Optional<Paciente> findByIdPaciente(Integer idPaciente);

    boolean existsByIdPaciente(Integer idPaciente);
}
