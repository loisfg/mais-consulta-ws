package com.bandtec.mais.consulta.domain;

import com.bandtec.mais.consulta.models.dto.request.MedicoSignUpRequestDTO;
import com.bandtec.mais.consulta.usecase.auth.MedicoSignUp;
import lombok.AllArgsConstructor;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class MedicoImportEexport {

    public void gravaRegistro(String registro, String nomeArq) {
        BufferedWriter saida = null;    // objeto usado para gravar no arquivo
        System.out.println(registro);
        // Abre o arquivo
        try {


            // Abre o arquivo com append = true, para poder ir acrescentando registros no arquivo
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro.getMessage());
        }

        // Grava o registro e fecha o arquivo
        try {
            saida.append(registro + "\n");  // Grava o registro e o final de registro (\n)
            saida.close();                  // Fecha o arquivo

        }
        catch (IOException erro) {
            System.out.println("Erro ao gravar no arquivo: " + erro.getMessage());
        }
    }

    public void gravaArquivoTxt(List<Medico> lista) {
        File file = new File( "Todos-os-medicos.txt" );
        file.delete();

        int contaRegDados = 0;      // contador de registros de dados (para poder gravar no trailer)
        // Monta o registro de header
        String header = "00MEDICO20212";
        Date dataDeHoje = new Date();       // Data e hora do momento, no formato padrão do Java
        SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");     // configura o padrão de formatação da data e horário
        header += formataData.format(dataDeHoje);   // Formata a data e hora para o padrão desejado
        header += "01";

        // Grava o header
        gravaRegistro(header, "Todos-os-medicos.txt");

        // Monta e grava o corpo do arquivo
        for (Medico a : lista) {
            // Monta o registro de corpo, de acordo com o especificado no documento de layout
            String corpo = "02";
            corpo += String.format("%-40.40s",a.getNome());
            corpo += String.format("%-4.4s",a.getUbs().getIdUbs());
            corpo += String.format("%-15.15s",a.getUsuario().getCpf());
            corpo += String.format("%-50.50s",a.getUsuario().getEmail());
            corpo += String.format("%-30.30s",a.getEspecialidade().getDescricao());

            // Incrementa o contador de registro de dados
            contaRegDados++;
            // Grava o registro de corpo no arquivo
            gravaRegistro(corpo, "Todos-os-medicos.txt");
        }

        // Monta e grava o registro de trailer
        String trailer = "01";
        trailer += String.format("%010d", contaRegDados);   // contador de registros de dados
        gravaRegistro(trailer, "Todos-os-medicos.txt");
        System.out.println(trailer);

    }
}
