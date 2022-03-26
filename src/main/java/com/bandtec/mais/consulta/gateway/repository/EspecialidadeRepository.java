package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Specialty;
import com.bandtec.mais.consulta.models.dto.response.SpecialtyResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;

public interface EspecialidadeRepository extends JpaRepository<Specialty, Integer> {
    boolean existsByDescricao(String descricao);

    Specialty findByDescricao(String descricao);

    Specialty findFirstByDescricao(String descricao);

    @Query("SELECT DISTINCT new com.bandtec.mais.consulta.models.dto.response.EspecialidadeResponseDTO(m.especialidade.descricao, m.especialidade.idEspecialidade) FROM Medico m")
    Optional<Set<SpecialtyResponseDTO>> findAllEspecialidades();
}
