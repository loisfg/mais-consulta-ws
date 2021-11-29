package com.bandtec.mais.consulta.models.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosPessoaisDTO {
    private Integer idPaciente;
    private String nome;
    private Integer idade;
    private String endereco;
    private String logradouro;
    private String complemento;
    private String numero;
    private String bairro;
    private String rg;
    private String numeroSus;
    private String cpf;
    private String telefone;
    private String cidade;
    private String estado;
    private String celular;
    private String cep;
}
