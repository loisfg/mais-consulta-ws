package com.bandtec.mais.consulta.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@ToString
@Table(name = "medico")
@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private Integer idMedico;

    @Column(name = "nome")
    private String nome;

    @PrimaryKeyJoinColumn(name = "id_usuario", referencedColumnName = "id_medico")
    @OneToOne(cascade = CascadeType.ALL)
    protected Usuario usuario;

    @JoinColumn(name = "fk_especialidade", referencedColumnName = "id_especialidade")
    @ManyToOne(cascade = CascadeType.ALL)
    protected Especialidade especialidade;

    private Medico() {}

    public Medico(String nome, Usuario usuario, Especialidade especialidade) {
        this.nome = nome;
        this.usuario = usuario;
        this.especialidade = especialidade;
    }

    public static MedicoEntityBuilder builder(){
        return new MedicoEntityBuilder();
    }

    public static class MedicoEntityBuilder {
        private String nome;
        private Usuario usuario;
        private Especialidade especialidade;

        public MedicoEntityBuilder setNome(final String nome) {
            this.nome = nome;
            return this;
        }

        public MedicoEntityBuilder setUsuario(final Usuario usuario) {
            this.usuario = usuario;
            return this;
        }

        public MedicoEntityBuilder setEspecialidade(final Especialidade especialidade) {
            this.especialidade = especialidade;
            return this;
        }

        public Medico build() {
            return new Medico(nome, usuario, especialidade);
        }
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
