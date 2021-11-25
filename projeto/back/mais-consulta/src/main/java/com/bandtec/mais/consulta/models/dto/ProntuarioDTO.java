package com.bandtec.mais.consulta.models.dto;

import com.bandtec.mais.consulta.domain.Alergia;
import com.bandtec.mais.consulta.domain.Deficiencia;
import com.bandtec.mais.consulta.domain.Doenca;
import com.bandtec.mais.consulta.domain.Remedio;
import com.bandtec.mais.consulta.models.enums.BloodTypeEnum;

import java.util.List;

public class ProntuarioDTO {
    private String peso = "";
    private Double altura = 0.0;
    private List<Doenca> doencasCronicas;
    private List<Remedio> remediosControlados;
    private List<Alergia> alergias;
    private List<Doenca> dsts;
    private List<Deficiencia> deficiencia;
    private boolean isFumante = false;
    private boolean isVirgem = false;
    private List<Doenca> doencasHereditarias;
    private BloodTypeEnum tipoSanguineo = BloodTypeEnum.DEFAULT;
    private List<String> atividadesProibidas;

    public ProntuarioDTO() {
    }

    public ProntuarioDTO(String peso, Double altura, List<Doenca> doencasCronicas, List<Remedio> remediosControlados, List<Alergia> alergias, List<Doenca> dsts, List<Deficiencia> deficiencia, boolean isFumante, boolean isVirgem, List<Doenca> doencasHereditarias, BloodTypeEnum tipoSanguineo, List<String> atividadesProibidas) {
        this.peso = peso;
        this.altura = altura;
        this.doencasCronicas = doencasCronicas;
        this.remediosControlados = remediosControlados;
        this.alergias = alergias;
        this.dsts = dsts;
        this.deficiencia = deficiencia;
        this.isFumante = isFumante;
        this.isVirgem = isVirgem;
        this.doencasHereditarias = doencasHereditarias;
        this.tipoSanguineo = tipoSanguineo;
        this.atividadesProibidas = atividadesProibidas;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public List<Doenca> getDoencasCronicas() {
        return doencasCronicas;
    }

    public void setDoencasCronicas(List<Doenca> doencasCronicas) {
        this.doencasCronicas = doencasCronicas;
    }

    public List<Remedio> getRemediosControlados() {
        return remediosControlados;
    }

    public void setRemediosControlados(List<Remedio> remediosControlados) {
        this.remediosControlados = remediosControlados;
    }

    public List<Alergia> getAlergias() {
        return alergias;
    }

    public void setAlergias(List<Alergia> alergias) {
        this.alergias = alergias;
    }

    public List<Doenca> getDsts() {
        return dsts;
    }

    public void setDsts(List<Doenca> dsts) {
        this.dsts = dsts;
    }

    public List<Deficiencia> getDeficiencia() {
        return deficiencia;
    }

    public void setDeficiencia(List<Deficiencia> deficiencia) {
        this.deficiencia = deficiencia;
    }

    public boolean isFumante() {
        return isFumante;
    }

    public void setFumante(boolean fumante) {
        isFumante = fumante;
    }

    public boolean isVirgem() {
        return isVirgem;
    }

    public void setVirgem(boolean virgem) {
        isVirgem = virgem;
    }

    public List<Doenca> getDoencasHereditarias() {
        return doencasHereditarias;
    }

    public void setDoencasHereditarias(List<Doenca> doencasHereditarias) {
        this.doencasHereditarias = doencasHereditarias;
    }

    public BloodTypeEnum getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(BloodTypeEnum tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public List<String> getAtividadesProibidas() {
        return atividadesProibidas;
    }

    public void setAtividadesProibidas(List<String> atividadesProibidas) {
        this.atividadesProibidas = atividadesProibidas;
    }
}
