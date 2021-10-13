package com.bandtec.mais.consulta.usecase.export.impl;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.gateway.database.repository.AgendamentoRepository;
import com.bandtec.mais.consulta.gateway.database.repository.UsuarioRepository;
import com.bandtec.mais.consulta.usecase.export.ExportAgendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.Optional;

@Service
public class ExportAgendamentoImpl implements ExportAgendamento {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public ByteArrayInputStream execute(Integer idUser, Integer idAgendamento) {

        if (usuarioRepository.existsById(idUser) && agendamentoRepository.existsById(idAgendamento)) {
            Usuario usuario = usuarioRepository.findById(idUser).get();

            Agendamento agendamento = agendamentoRepository.findByUsuarioAndIdAgendamento(usuario.getIdUsuario(), idAgendamento).get();

            String nomeArquivo = String.format("%d_%d_%s", idUser, idAgendamento, agendamento.getDataHr());
            gravaArquivoCsv(agendamento, nomeArquivo);
        }

        return null;
    }

    public static void gravaArquivoCsv(Agendamento agendamento, String nomeArquivo) {

        boolean deuRuim = false;
        FileWriter arquivo = null;
        Formatter saida = null;
        nomeArquivo += ".csv";

        try {
            arquivo = new FileWriter(nomeArquivo, false);
            saida = new Formatter(arquivo);
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        try {
            saida.format("%d;%s;%s;%s\n",
                    agendamento.getIdAgendamento(),
                    agendamento.getDataHr(),
                    agendamento.getUsuario(),
                    agendamento.getMedico());
        } catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar no arquivo");
            deuRuim = true;
        } finally {
            saida.close();

            try {
                arquivo.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
        }
        if (deuRuim) {
            System.exit(1);
        }

    }

}
