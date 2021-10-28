package com.bandtec.mais.consulta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "especialidade")
public class Especialidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidade", nullable = false)
    private Integer idEspecialidade;

    @Column(name = "descricao")
    private String descricao;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "especialidade")
    List<Medico> medicos = new ArrayList<Medico>();

    private Especialidade() {};

    public Especialidade(String descricao) {
        this.descricao = descricao;
    }

    public static EspecialidadeEntityBuilder builder(){
        return new EspecialidadeEntityBuilder();
    }

    public static class EspecialidadeEntityBuilder {
        private String descricao;
        private List<Medico> medicos;

        public EspecialidadeEntityBuilder setDescricao(final String descricao) {
            this.descricao = descricao;
            return this;
        }
        public Especialidade build(){
            return new Especialidade(descricao);
        }

    }


    @Override
    public String toString() {
        return "Especialidade{" +
                "idEspecialidade=" + idEspecialidade +
                ", descricao='" + descricao + '\'' +
                ", medicos=" + medicos +
                '}';
    }
}

