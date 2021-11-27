package com.bandtec.mais.consulta.usecase.doctor.impl;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.models.dto.DadosPessoaisDTO;
import com.bandtec.mais.consulta.models.dto.ProntuarioDTO;
import com.bandtec.mais.consulta.models.dto.request.PacienteInfoRequestDTO;
import com.bandtec.mais.consulta.models.enums.BloodTypeEnum;
import com.bandtec.mais.consulta.usecase.doctor.PostFormularioAtendimento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.beans.Beans;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostFormularioAtendimentoImpl implements PostFormularioAtendimento {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Optional<?> execute(Integer idMedico, Integer idPaciente, PacienteInfoRequestDTO pacienteInfoRequestDTO) {

        if (medicoRepository.existsByIdMedico(idMedico) && pacienteRepository.existsByIdPaciente(idPaciente)) {

            DadosPessoaisDTO dadosPessoaisDTO = pacienteInfoRequestDTO.getDadosPessoais();
            ProntuarioDTO prontuarioDTO = pacienteInfoRequestDTO.getProntuario();

            List<Doenca> doencaList = new ArrayList<>();

            List<Doenca> doencaHereditariaList = prontuarioDTO.getDoencasHereditarias();
            List<Doenca> doencaCronicaList = prontuarioDTO.getDoencasCronicas();
            List<Doenca> doencaDSTList = prontuarioDTO.getDsts();
            List<Deficiencia> deficienciaList = prontuarioDTO.getDeficiencia();
            List<Remedio> remedioList = prontuarioDTO.getRemediosControlados();
            List<Alergia> alergiaList = prontuarioDTO.getAlergias();

            Paciente paciente = new Paciente();

            paciente.setIdPaciente(dadosPessoaisDTO.getIdPaciente());
            paciente.setNome(dadosPessoaisDTO.getNome());
//            paciente.setDtNascimento();
            paciente.setTelefone(dadosPessoaisDTO.getTelefone());
//            paciente.setSexo();
            paciente.setNumeroCarteiraSus(dadosPessoaisDTO.getNumeroSus());
            paciente.setPeso(prontuarioDTO.getPeso());
            paciente.setAltura(prontuarioDTO.getAltura());
            paciente.setIsVirgem(prontuarioDTO.isVirgem());
            paciente.setIsFumante(prontuarioDTO.isFumante());
            paciente.setTipoSanguineo(prontuarioDTO.getTipoSanguineo());
//            paciente.setEndereco();
//            paciente.setUsuario();

            PacienteHasRemediosKey pacienteHasRemediosKey = PacienteHasRemediosKey.builder()
                    .pacienteId(idPaciente)
                    .remedioId(1)
                    .build();


            PacienteHasRemedios.builder()
                    .id(pacienteHasRemediosKey)
                    .remedio(remedioList.get(1))
                    .build();
//            paciente.setDoencas();
//            paciente.setRemedios();
//            paciente.setPacienteDeficiencias();
//            paciente.setPacienteAlergias();


        }

        return Optional.empty();
    }
}
