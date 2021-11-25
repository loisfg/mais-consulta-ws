package com.bandtec.mais.consulta.models.dto;

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

    public DadosPessoaisDTO() {
    }

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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNumeroSus() {
        return numeroSus;
    }

    public void setNumeroSus(String numeroSus) {
        this.numeroSus = numeroSus;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
