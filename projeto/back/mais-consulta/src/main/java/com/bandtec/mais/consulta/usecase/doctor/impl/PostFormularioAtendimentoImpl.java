package com.bandtec.mais.consulta.usecase.doctor.impl;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.gateway.repository.AgendamentoRepository;
import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.models.dto.DadosPessoaisDTO;
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

    @Override
    public Optional<?> execute(Integer idMedico, Integer idPaciente, PacienteInfoRequestDTO pacienteInfoRequestDTO) {

        if (medicoRepository.existsByIdMedico(idMedico) && pacienteRepository.existsByIdPaciente(idPaciente)) {

            DadosPessoaisDTO dadosPessoaisDTO = pacienteInfoRequestDTO.getDadosPessoais();
            ProntuarioResquestDTO prontuarioDTO = pacienteInfoRequestDTO.getProntuario();

            if (pacienteRepository.existsById(idPaciente)) {

                Set<PacienteHasAlergia> alergiaSet = new HashSet<>();
                Set<PacienteHasRemedios> remedioSet = new HashSet<>();
                Set<PacienteHasDoencas> doencaSet = new HashSet<>();
                Set<PacienteHasDeficiencia> deficienciaSet = new HashSet<>();
                Set<PacienteHasAtividade> atividadeSet = new HashSet<>();

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
                // Remedio
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
                // Doenca
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
                // Deficiencia
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
                // Atividades
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

                pacienteRepository.save(paciente);
                agendamentoRepository.updateAgendamentoStatus(pacienteInfoRequestDTO.getIdAgendamento(), "FINALIZADO");


                return Optional.of(paciente);
            }
        }
        return Optional.empty();
    }
}