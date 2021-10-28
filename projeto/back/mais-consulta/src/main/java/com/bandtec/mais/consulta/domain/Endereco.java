package com.bandtec.mais.consulta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Integer idEndereco;

    @Column(name = "cep")
    private String cep;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "numero")
    private String numero;

    @Column(name = "complemento")
    private String complemento;

    protected Endereco() {}

    public Endereco(String cep, String cidade, String estado, String bairro, String logradouro, String numero, String complemento) {
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public static EnderecoEntityBuilder builder() {
        return new EnderecoEntityBuilder();
    }

    public static class EnderecoEntityBuilder {
        private String cep;
        private String cidade;
        private String estado;
        private String bairro;
        private String logradouro;
        private String numero;
        private String complemento;

        public EnderecoEntityBuilder setCep(final String cep) {
            this.cep = cep;
            return this;
        }

        public EnderecoEntityBuilder setCidade(final String cidade) {
            this.cidade = cidade;
            return this;
        }

        public EnderecoEntityBuilder setEstado(final String estado) {
            this.estado = estado;
            return this;
        }

        public EnderecoEntityBuilder setBairro(final String bairro) {
            this.bairro = bairro;
            return this;
        }

        public EnderecoEntityBuilder setLogradouro(final String logradouro) {
            this.logradouro = logradouro;
            return this;
        }

        public EnderecoEntityBuilder setNumero(final String numero) {
            this.numero = numero;
            return this;
        }

        public EnderecoEntityBuilder setComplemento(final String complemento) {
            this.complemento = complemento;
            return this;
        }

        public Endereco build() {
            return new Endereco(cep,cidade,estado,bairro,logradouro,numero,cidade);
        }
    }


    @Override
    public String toString() {
        return "Endereco{" +
                "idEndereco=" + idEndereco +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", bairro='" + bairro + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                '}';
    }
}
