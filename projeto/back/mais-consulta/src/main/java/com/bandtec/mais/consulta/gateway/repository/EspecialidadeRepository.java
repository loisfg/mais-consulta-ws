package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Especialidade;
import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.models.dto.response.EspecialidadeResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Integer> {
    boolean existsByDescricao(String descricao);

    Especialidade findByDescricao(String descricao);

    Especialidade findFirstByDescricao(String descricao);

    @Query("SELECT DISTINCT new com.bandtec.mais.consulta.models.dto.response.EspecialidadeResponseDTO(m.especialidade.descricao, m.especialidade.idEspecialidade) FROM Medico m")
    Optional<Set<EspecialidadeResponseDTO>> findAllEspecialidades();
}
