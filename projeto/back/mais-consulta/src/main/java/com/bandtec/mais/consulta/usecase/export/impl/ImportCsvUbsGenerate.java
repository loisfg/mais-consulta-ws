package com.bandtec.mais.consulta.usecase.export.impl;

import com.bandtec.mais.consulta.domain.Endereco;
import com.bandtec.mais.consulta.domain.Ubs;
import com.bandtec.mais.consulta.gateway.repository.EnderecoRepository;
import com.bandtec.mais.consulta.gateway.repository.UbsRepository;
import com.bandtec.mais.consulta.usecase.export.ImportCsv;
import com.bandtec.mais.consulta.utils.StrFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
public class ImportCsvUbsGenerate implements ImportCsv {

    @Autowired
    UbsRepository ubsRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    public static List<Ubs> leSalvaUbsCmEndereco(List<Endereco> enderecoList) {
        FileReader arq = null;
        Scanner entrada = null;
        Boolean deuRuim = false;
        List<Ubs> list = new ArrayList();
        String nomeArq = "ubs.csv";

        try {
            arq = new FileReader(nomeArq);
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo não encontrado");
            System.exit(1);
        }
        Random gerador = new Random();

        try {
            while (entrada.hasNext()) {
                Integer id = list.size() + 1;
                String nome = entrada.next();
                String telefone = "(11)" + gerador.nextInt(8999) + "-" + gerador.nextInt(9999);
                list.add(new Ubs(id, nome, telefone, enderecoList.get(id - 1)));
            }
        } catch (NoSuchElementException erro) {
            System.out.println("Arquivo com problemas");
            deuRuim = true;
        } catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            deuRuim = true;
        } finally {
            entrada.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }

        list.removeIf(ubs -> ubs.getNome().equals(""));

        return list;
    }

    public static List<Endereco> leSalvaEndereco() {
        FileReader arq = null;
        Scanner entrada = null;
        Boolean deuRuim = false;
        String nomeArq = "endereco.csv";

        try {
            arq = new FileReader(nomeArq);
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo não encontrado " + erro);
            System.exit(1);
        }

        List<Endereco> listEndereco = new ArrayList<>();

        List<String> estados = List.of("SP", "RJ", "ES", "MT", "MG");

        Random gerador = new Random();
        try {
            while (entrada.hasNext()) {
                Integer id = listEndereco.size() + 1;
                String cep = gerador.nextInt(+99999) + "-" + gerador.nextInt(+999);
                String estado = estados.get(gerador.nextInt(estados.size()));
                String logradouro = "";
                String rua = StrFormat.toTitledCase(entrada.next());
                String bairro = StrFormat.toTitledCase(entrada.next());
                String cidade = "Jd " + StrFormat.toTitledCase(bairro);
                String numero = String.valueOf(gerador.nextInt(+2000));
                String complemento = "";
                Endereco endereco = new Endereco(id, cep, cidade, estado, bairro, rua, logradouro, numero, complemento);
                listEndereco.add(endereco);
            }
        } catch (NoSuchElementException erro) {
            System.out.println("Arquivo com problemas");
            deuRuim = true;
        } catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            deuRuim = true;
        } finally {
            entrada.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }

        return listEndereco;
    }

    @Override
    public void run() {
        List<Endereco> enderecoList = leSalvaEndereco();
        List<Ubs> listUbs = leSalvaUbsCmEndereco(enderecoList);
//
//        for (int i = 0; i < 40; i++) {
//            System.out.println("Salvei mais um endereço");
//            enderecoRepository.save(enderecoList.get(i));
//        }
//
//        for (int i = 0; i < 40; i++) {
//            System.out.println("Salvei mais uma ubs");
//            ubsRepository.save(listUbs.get(i));
//        }
    }
}
