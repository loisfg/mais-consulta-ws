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

    public void gravaArquivoTxt(List<MedicoSignUpRequestDTO> lista) {

        int contaRegDados = 0;      // contador de registros de dados (para poder gravar no trailer)
        System.out.println(lista);
        // Monta o registro de header
        String header = "00MEDICO20212";
        Date dataDeHoje = new Date();       // Data e hora do momento, no formato padrão do Java
        SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");     // configura o padrão de formatação da data e horário
        header += formataData.format(dataDeHoje);   // Formata a data e hora para o padrão desejado
        header += "01";

        // Grava o header
        gravaRegistro(header, "Todos-os-medicos");

        // Monta e grava o corpo do arquivo
        for (MedicoSignUpRequestDTO a : lista) {
            // Monta o registro de corpo, de acordo com o especificado no documento de layout
            String corpo = "02";
            corpo += String.format("%-40.40s",a.getMedico().getNome());
            corpo += String.format("%-4.4s",a.getIdUbs());
            corpo += String.format("%-15.15s",a.getCpf());
            corpo += String.format("%-50.50s",a.getEmail());
            corpo += String.format("%-30.30s",a.getPassword());
            corpo += String.format("%-30.30s",a.getMedico().getEspecialidade().getDescricao());

            // Incrementa o contador de registro de dados
            contaRegDados++;
            // Grava o registro de corpo no arquivo
            gravaRegistro(corpo, "Todos-os-medicos");
        }

        // Monta e grava o registro de trailer
        String trailer = "01";
        trailer += String.format("%010d", contaRegDados);   // contador de registros de dados
        gravaRegistro(trailer, "Todos-os-medicos.txt");
        System.out.println(trailer);

    }
    public void leArquivoTxt() {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String ra, nome, curso, disciplina;
        Double media;
        int qtdFalta;
        int qtdRegistrosGravados;
        //int contaRegDados = 0; // vamos usar o size() da listaLida

        List<Medico> listaLida = new ArrayList();

        // Abre o arquivo
        try {
            entrada = new BufferedReader(new FileReader("Todos os medicos"));
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro.getMessage());
        }

        // Lê o arquivo
        try{
            // Lê o primeiro registro do arquivo
            registro = entrada.readLine();

            while (registro != null) { // enquanto não chegou ao fim do arquivo
                // Obtém os 2 primeiros caracteres do registro
                // Atenção, pois o substring considera que a string começa no índice zero (como um vetor)
                // Então para obter os 2 primeiros caracteres, passamos que começa no zero
                // E o substring recebe a posição final desejada + 1
                // Por isso chamamos substring(0, 2)
                //      012345
                //      00NOTA
                tipoRegistro = registro.substring(0, 2);

                if (tipoRegistro.equals("00")) {
                    System.out.println("Eh um registro de header");
                    System.out.println("Tipo de arquivo: "+registro.substring(2,6));
                    System.out.println("Ano/semestre: "+registro.substring(6,11));
                    System.out.println("Data/hora de gravação: "+registro.substring(11,30));
                    System.out.println("Versão do documento: "+registro.substring(30,32));
                }
                else  if (tipoRegistro.equals("01")) {
                    System.out.println("Eh um registro de trailer");
                    qtdRegistrosGravados = Integer.valueOf(registro.substring(2, 12));
                    // Validação se a quantidade de registros que está no trailer é igual à
                    // quantidade lida de registros
                    if (qtdRegistrosGravados == listaLida.size()) {
                        System.out.println("Quantidade de registros gravados compatível com quantidade lida");
                    }
                    else {
                        System.out.println("Quantidade de registros gravados não confere com quantidade lida");
                    }
                }
                else  if (tipoRegistro.equals("02")) {
                    System.out.println("Eh um registro de corpo");
                    curso = registro.substring(2,7).trim();     // o trim() remove os brancos à direita
                    ra = registro.substring(7,15);
                    nome = registro.substring(15,65).trim();
                    disciplina = registro.substring(65,105).trim();
                    // Para converter para Double, precisamos substituir a ',' por '.'
                    media = Double.valueOf(registro.substring(105,110).replace(',','.'));
                    qtdFalta = Integer.valueOf(registro.substring(110,113));
                    // Criamos um objeto com os atributos lidos do registro de corpo
                    Medico a = new Medico();
                    // Adicionamos esse objeto à listaLida
                    listaLida.add(a);
                    //contaRegDados++;
                }
                else {
                    System.out.println("Tipo de registro inválido!");
                }

                // Lê o próximo registro
                registro = entrada.readLine();

            }
            entrada.close();    // Fecha o arquivo
        }
        catch (IOException erro) {
            System.out.println("Erro ao ler o arquivo: " + erro.getMessage());
        }

        // Exibe o conteúdo da listaLida
        System.out.println("\nConteúdo lido do arquivo:");
        for (Medico a : listaLida) {
            System.out.println(a);
        }
    }

}
