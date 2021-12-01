package com.bandtec.mais.consulta.usecase.doctor.impl;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.gateway.repository.*;
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
    private UsuarioRepository usuarioRepository;

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

                if (pacienteInfoRequestDTO.getProntuario().getAlergias() != null) {
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

                        PacienteHasRemedios pacienteHasRemedios = PacienteHasRemedios
                                .builder()
                                .id(fk)
                                .build();

                        remedioSet.add(pacienteHasRemedios);
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

                        PacienteHasDoencas pacienteHasDoencas = PacienteHasDoencas
                                .builder()
                                .id(fk)
                                .build();

                        doencaSet.add(pacienteHasDoencas);
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

                        PacienteHasDeficiencia pacienteHasDeficiencia = PacienteHasDeficiencia
                                .builder()
                                .id(fk)
                                .build();

                        deficienciaSet.add(pacienteHasDeficiencia);
                    }
                }
                // Atividades
                if (pacienteInfoRequestDTO.getProntuario().getAtividadesProibidas() != null) {
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

                Paciente paciente = pacienteRepository.findById(idPaciente).get();

                paciente.setIdPaciente(idPaciente);
                paciente.setAlergias(alergiaSet);
                paciente.setAtividades(atividadeSet);
                paciente.setDeficiencias(deficienciaSet);
                paciente.setRemedios(remedioSet);
                paciente.setDoencas(doencaSet);
                paciente.setNome(dadosPessoaisDTO.getNome());
                paciente.setTelefone(dadosPessoaisDTO.getTelefone());
                paciente.setPeso(prontuarioDTO.getPeso());
                paciente.setAltura(prontuarioDTO.getAltura());
                paciente.setIsVirgem(prontuarioDTO.isVirgem());
                paciente.setIsFumante(prontuarioDTO.isFumante());
                paciente.setTipoSanguineo(prontuarioDTO.getTipoSanguineo());

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