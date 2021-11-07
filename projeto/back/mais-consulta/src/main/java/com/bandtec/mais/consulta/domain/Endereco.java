package com.bandtec.mais.consulta.domain;

import com.bandtec.mais.consulta.models.enums.EstadosEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Integer idEndereco;

    @Pattern(regexp = "\\d{5}(-\\d{3})?", message = "Digite um CEP válido")
    private String cep;
    private String cidade;
    @Size(max = 2, min =2)
    private String estado;
    private String bairro;
    private String logradouro;
    private String numero;
    private String complemento;

    //TODO retirar JsonIgnore e adicionar DTO's para retorno dos métodos!
    @JsonIgnore
    @OneToOne(mappedBy = "endereco")
    private Paciente paciente;

    @JsonIgnore
    @OneToOne(mappedBy = "endereco")
    private Ubs ubs;
}
