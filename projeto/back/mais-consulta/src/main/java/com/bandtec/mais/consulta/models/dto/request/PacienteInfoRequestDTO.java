package com.bandtec.mais.consulta.models.dto.request;

import com.bandtec.mais.consulta.models.dto.DadosPessoaisDTO;
import com.bandtec.mais.consulta.models.dto.ProntuarioDTO;

public class PacienteInfoRequestDTO {
    private DadosPessoaisDTO dadosPessoais;
    private ProntuarioDTO prontuario;

    public PacienteInfoRequestDTO() {
    }

    public PacienteInfoRequestDTO(DadosPessoaisDTO dadosPessoais, ProntuarioDTO prontuario) {
        this.dadosPessoais = dadosPessoais;
        this.prontuario = prontuario;
    }

    public DadosPessoaisDTO getDadosPessoais() {
        return dadosPessoais;
    }

    public void setDadosPessoais(DadosPessoaisDTO dadosPessoais) {
        this.dadosPessoais = dadosPessoais;
    }

    public ProntuarioDTO getProntuario() {
        return prontuario;
    }

    public void setProntuario(ProntuarioDTO prontuario) {
        this.prontuario = prontuario;
    }
}
