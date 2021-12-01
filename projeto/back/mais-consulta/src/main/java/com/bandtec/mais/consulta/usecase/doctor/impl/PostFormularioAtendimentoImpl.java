package com.bandtec.mais.consulta.usecase.doctor.impl;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.gateway.repository.AgendamentoRepository;
import com.bandtec.mais.consulta.gateway.repository.DiagnosticoRepository;
import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.models.dto.DadosPessoaisDTO;
import com.bandtec.mais.consulta.models.dto.request.DiagnosticoDTO;
import com.bandtec.mais.consulta.models.dto.request.PacienteInfoRequestDTO;
import com.bandtec.mais.consulta.models.dto.request.ProntuarioResquestDTO;
import com.bandtec.mais.consulta.usecase.doctor.PostFormularioAtendimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PostFormularioAtendimentoImpl implements PostFormularioAtendimento {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    @Override
    public Optional<?> execute(Integer idMedico, Integer idPaciente, Integer idAgendamento, PacienteInfoRequestDTO pacienteInfoRequestDTO) {

        if (medicoRepository.existsByIdMedico(idMedico) && pacienteRepository.existsByIdPaciente(idPaciente)) {

            DadosPessoaisDTO dadosPessoaisDTO = pacienteInfoRequestDTO.getDadosPessoais();
            ProntuarioResquestDTO prontuarioDTO = pacienteInfoRequestDTO.getProntuario();
            DiagnosticoDTO diagnosticoDTO = pacienteInfoRequestDTO.getDiagnostico();

            if (pacienteRepository.existsById(idPaciente)) {

                Set<PacienteHasAlergia> alergiaSet = new HashSet<>();
                Set<PacienteHasRemedios> remedioSet = new HashSet<>();
                Set<PacienteHasDoencas> doencaSet = new HashSet<>();
                Set<PacienteHasDeficiencia> deficienciaSet = new HashSet<>();
                Set<PacienteHasAtividade> atividadeSet = new HashSet<>();

                if(pacienteInfoRequestDTO.getProntuario().getAlergias() != null) {
                    for (Integer ids : pacienteInfoRequestDTO.getProntuario().getAlergias()) {
                        PacienteHasAlergiaKey fk = PacienteHasAlergiaKey
                                .builder()
                                .alergiaId(ids)
                                .pacienteId(idPaciente)
                                .build();

                        PacienteHasAlergia pacienteHasAlergia = PacienteHasAlergia
                                .builder()
                                .id(fk)
                                .build();

                        alergiaSet.add(pacienteHasAlergia);
                    }
                }
                // Remedio
                if (pacienteInfoRequestDTO.getProntuario().getRemedios() != null) {
                    for (Integer ids : pacienteInfoRequestDTO.getProntuario().getRemedios()) {
                        PacienteHasRemediosKey fk = PacienteHasRemediosKey
                                .builder()
                                .remedioId(ids)
                                .pacienteId(idPaciente)
                                .build();

                        PacienteHasRemedios pacienteHasAlergia = PacienteHasRemedios
                                .builder()
                                .id(fk)
                                .build();

                        remedioSet.add(pacienteHasAlergia);
                    }
                }
                // Doenca
                if (pacienteInfoRequestDTO.getProntuario().getDoencas() != null) {
                    for (Integer ids : pacienteInfoRequestDTO.getProntuario().getDoencas()) {
                        PacienteHasDoencasKey fk = PacienteHasDoencasKey
                                .builder()
                                .doencaId(ids)
                                .pacienteId(idPaciente)
                                .build();

                        PacienteHasDoencas pacienteHasAlergia = PacienteHasDoencas
                                .builder()
                                .id(fk)
                                .build();

                        doencaSet.add(pacienteHasAlergia);
                    }
                }
                // Deficiencia
                if (pacienteInfoRequestDTO.getProntuario().getDeficiencia() != null) {
                    for (Integer ids : pacienteInfoRequestDTO.getProntuario().getDeficiencia()) {
                        PacienteHasDeficienciaKey fk = PacienteHasDeficienciaKey
                                .builder()
                                .deficienciaId(ids)
                                .pacienteId(idPaciente)
                                .build();

                        PacienteHasDeficiencia pacienteHasAlergia = PacienteHasDeficiencia
                                .builder()
                                .id(fk)
                                .build();

                        deficienciaSet.add(pacienteHasAlergia);
                    }
                }
                // Atividades
                if(pacienteInfoRequestDTO.getProntuario().getAtividadesProibidas() != null) {
                    for (Integer ids : pacienteInfoRequestDTO.getProntuario().getAtividadesProibidas()) {
                        PacienteHasAtividadeKey fk = PacienteHasAtividadeKey
                                .builder()
                                .atividadeId(ids)
                                .pacienteId(idPaciente)
                                .build();

                        PacienteHasAtividade pacienteHasAtividade = PacienteHasAtividade
                                .builder()
                                .id(fk)
                                .build();

                        atividadeSet.add(pacienteHasAtividade);
                    }
                }

                Paciente paciente = Paciente
                        .builder()
                        .idPaciente(idPaciente)
                        .alergias(alergiaSet)
                        .atividades(atividadeSet)
                        .deficiencias(deficienciaSet)
                        .remedios(remedioSet)
                        .doencas(doencaSet)
                        .nome(dadosPessoaisDTO.getNome())
                        .telefone(dadosPessoaisDTO.getTelefone())
                        .peso(prontuarioDTO.getPeso())
                        .altura(prontuarioDTO.getAltura())
                        .isVirgem(prontuarioDTO.isVirgem())
                        .isFumante(prontuarioDTO.isFumante())
                        .tipoSanguineo(prontuarioDTO.getTipoSanguineo())
                        .build();

                Diagnostico diagnostico = Diagnostico
                        .builder()
                        .medicamento(diagnosticoDTO.getMedicamentos())
                        .orientacoesMedicas(diagnosticoDTO.getOrientacoesMedicas())
                        .queixa(diagnosticoDTO.getQueixa())
                        .terminologia(diagnosticoDTO.getTerminologia())
                        .agendamento(agendamentoRepository.getById(idAgendamento))
                        .build();

                diagnosticoRepository.save(diagnostico);
                pacienteRepository.save(paciente);
                agendamentoRepository.updateAgendamentoStatus(idAgendamento, "FINALIZADO", idPaciente);

                return Optional.of(paciente);
            }
        }
        return Optional.empty();
    }
}