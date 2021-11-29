package com.bandtec.mais.consulta.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DadosPessoaisDTO {
    private Integer idPaciente;
    private String nome;
    private Integer idade;
    private String endereco;
    private String bairro;
    private String rg;
    private String numeroSus;
    private String cpf;
    private String telefone;
    private String cidade;
    private String estado;
    private String celular;
    private String cep;

    public DadosPessoaisDTO(Integer idPaciente, String nome, Integer idade, String endereco, String bairro, String numeroSus, String cpf, String telefone, String cidade, String estado, String cep) {
        this.idPaciente = idPaciente;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.bairro = bairro;
        this.numeroSus = numeroSus;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
}
