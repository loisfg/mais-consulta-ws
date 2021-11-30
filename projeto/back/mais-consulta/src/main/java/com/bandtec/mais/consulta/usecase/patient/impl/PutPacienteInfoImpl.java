package com.bandtec.mais.consulta.usecase.patient.impl;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.gateway.repository.*;
import com.bandtec.mais.consulta.models.dto.request.PacienteInfoPutResquestDTO;
import com.bandtec.mais.consulta.usecase.patient.PutPacienteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PutPacienteInfoImpl implements PutPacienteInfo {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteHasRemediosRepository remedioRepository;

    @Autowired
    private PacienteHasDoencasRepository doencaRepository;

    @Autowired
    private PacienteHasDeficienciaRepository deficienciaRepository;

    @Autowired
    private PacienteHasAlergiaRepository alergiaRepository;

    @Autowired
    private PacienteHasAtividadeRepository atividadeRepository;

    @Override
    public Optional<Paciente> execute(Integer idPaciente, PacienteInfoPutResquestDTO pacienteInfoResponseDTO) {
        if (pacienteRepository.existsById(idPaciente)) {

            Set<PacienteHasAlergia> alergiaSet = alergiaRepository.findRemedioByIdPaciente(idPaciente);
            Set<PacienteHasRemedios> remedioSet = remedioRepository.findRemedioByIdPaciente(idPaciente);
            Set<PacienteHasDoencas> doencaSet = doencaRepository.findRemedioByIdPaciente(idPaciente);
            Set<PacienteHasDeficiencia> deficienciaSet = deficienciaRepository.findRemedioByIdPaciente(idPaciente);
            Set<PacienteHasAtividade> atividadeSet = atividadeRepository.findRemedioByIdPaciente(idPaciente);

            // Alergias
            if(pacienteInfoResponseDTO.getProntuario().getAlergias() != null) {
                for (Integer ids : pacienteInfoResponseDTO.getProntuario().getAlergias()) {
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
            if (pacienteInfoResponseDTO.getProntuario().getRemedios() != null) {
                for (Integer ids : pacienteInfoResponseDTO.getProntuario().getRemedios()) {
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
            if (pacienteInfoResponseDTO.getProntuario().getDoencas() != null) {
                for (Integer ids : pacienteInfoResponseDTO.getProntuario().getDoencas()) {
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
            if (pacienteInfoResponseDTO.getProntuario().getDeficiencia() != null) {
                for (Integer ids : pacienteInfoResponseDTO.getProntuario().getDeficiencia()) {
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
            if(pacienteInfoResponseDTO.getProntuario().getAtividadesProibidas() != null) {
                for (Integer ids : pacienteInfoResponseDTO.getProntuario().getAtividadesProibidas()) {
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
                    .nome(pacienteInfoResponseDTO.dadosPessoais.getNome())
                    .telefone(pacienteInfoResponseDTO.dadosPessoais.getTelefone())
                    .peso(pacienteInfoResponseDTO.prontuario.getPeso())
                    .altura(pacienteInfoResponseDTO.prontuario.getAltura())
                    .isVirgem(pacienteInfoResponseDTO.prontuario.isVirgem())
                    .isFumante(pacienteInfoResponseDTO.prontuario.isFumante())
                    .tipoSanguineo(pacienteInfoResponseDTO.prontuario.getTipoSanguineo())
                    .build();

            pacienteRepository.save(paciente);

            return Optional.of(paciente);
        }

        return Optional.empty();
    }
}
