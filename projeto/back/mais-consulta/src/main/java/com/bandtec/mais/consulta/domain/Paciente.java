package com.bandtec.mais.consulta.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@Getter
@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Integer idPaciente;

    private String nome;

    @Column(name = "dt_nascimento")
    private LocalDate dtNascimento;

    private String telefone;

    private String sexo;

    @Column(name = "numero_carteira_sus")
    private String numeroCarteiraSus;

    @PrimaryKeyJoinColumn(name = "idEndereco", referencedColumnName = "idPaciente")
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    protected Usuario usuario;

    protected Paciente() {}

    private Paciente(String nome, LocalDate dtNascimento, String telefone, String sexo, String numeroCarteiraSus, Endereco endereco, Usuario usuario) {
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.telefone = telefone;
        this.sexo = sexo;
        this.numeroCarteiraSus = numeroCarteiraSus;
        this.endereco = endereco;
        this.usuario = usuario;
    }

    // Criando builder (de preferencia usar essa instancia)
    public static PacienteEntityBuilder builder() {
        return new PacienteEntityBuilder();
    }

    public static class PacienteEntityBuilder {
        private String nome;
        private LocalDate dtNascimento;
        private String telefone;
        private String sexo;
        private String numeroCarteiraSus;
        private Endereco endereco;
        protected Usuario usuario;

        public PacienteEntityBuilder setName(final String nome) {
            this.nome = nome;
            return this;
        }

        public PacienteEntityBuilder setDtNascimento(final LocalDate dtNascimento) {
            this.dtNascimento = dtNascimento;
            return this;
        }

        public PacienteEntityBuilder setTelefone(final String telefone) {
            this.telefone = telefone;
            return this;
        }

        public PacienteEntityBuilder setSexo(final String sexo) {
            this.sexo = sexo;
            return this;
        }

        public PacienteEntityBuilder setNumeroCarteiraSus(final String numeroCarteiraSus) {
            this.numeroCarteiraSus = numeroCarteiraSus;
            return this;
        }

        public PacienteEntityBuilder setEndereco(final Endereco endereco) {
            this.endereco = endereco;
            return this;
        }

        public PacienteEntityBuilder setUsuario(final Usuario usuario) {
            this.usuario = usuario;
            return this;
        }

        public Paciente build() {
            return new Paciente(nome, dtNascimento, telefone, sexo, numeroCarteiraSus, endereco, usuario);
        }
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNumeroCarteiraSus() {
        return numeroCarteiraSus;
    }

    public void setNumeroCarteiraSus(String numeroCarteiraSus) {
        this.numeroCarteiraSus = numeroCarteiraSus;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(idPaciente, paciente.idPaciente);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "nome = " + nome + ", " +
                "dtNascimento = " + dtNascimento + ", " +
                "telefone = " + telefone + ", " +
                "sexo = " + sexo + ", " +
                "numeroCarteiraSus = " + numeroCarteiraSus + ", " +
                "endereco = " + endereco + ", " +
                "usuario = " + usuario + ")";
    }
}
