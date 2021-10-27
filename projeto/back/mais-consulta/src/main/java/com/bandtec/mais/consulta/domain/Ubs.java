package com.bandtec.mais.consulta.domain;

import javax.persistence.*;

@Table(name = "ubs")
@Entity
public class Ubs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUbs;

    @Column(name = "nome")
    private String nome;

    @PrimaryKeyJoinColumn(name = "idEndereco", referencedColumnName = "idUbs")
    @OneToOne(cascade = CascadeType.PERSIST)
    private Endereco endereco;

    private Ubs() {}

    public Ubs(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public static UbsEntityBuilder builder() {
        return new UbsEntityBuilder();
    }

    public static class UbsEntityBuilder {
        private String nome;
        private Endereco endereco;

        public UbsEntityBuilder setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public UbsEntityBuilder setEndereco(Endereco endereco) {
            this.endereco = endereco;
            return this;
        }

        public Ubs build() {
            return new Ubs(nome, endereco);
        }
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdUbs() {
        return idUbs;
    }

    public void setIdUbs(Integer idUbs) {
        this.idUbs = idUbs;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
