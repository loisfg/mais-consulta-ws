package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Especialidade;
import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.domain.Usuario;
import org.hibernate.annotations.Parameter;
import org.junit.runners.Parameterized;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {

    @Query(value =
           "SELECT medico.Id_medico FROM medico INNER JOIN ubs ON ubs.ID_UBS = medico.UBS_ID " +
           "JOIN especialidade ON especialidade.ID_ESPECIALIDADE = medico.ESPECIALIDADE_ID " +
           "WHERE UBS.ID_UBS =:id", nativeQuery = true)
    Optional<List<Integer>> findIdsMedicosByIdEspecialidade(@Param("id")Integer id);


    boolean existsByNome(String nome);

    List<Medico> findByNome(String nome);

    Set<Medico> findAllByEspecialidade(Especialidade especialidade);

    Optional<Medico> findByUsuario(Usuario usuario);
}
