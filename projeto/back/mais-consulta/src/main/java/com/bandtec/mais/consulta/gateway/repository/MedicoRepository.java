package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Especialidade;
import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    boolean existsByNome(String nome);

    List<Medico> findByNome(String nome);

    Set<Medico> findAllByEspecialidade(Especialidade especialidade);

    Optional<Medico> findByUsuario(Usuario usuario);
}
