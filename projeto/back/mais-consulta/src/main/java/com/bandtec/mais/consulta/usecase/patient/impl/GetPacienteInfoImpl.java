package com.bandtec.mais.consulta.usecase.patient.impl;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.gateway.repository.*;
import com.bandtec.mais.consulta.models.dto.DadosPessoaisDTO;
import com.bandtec.mais.consulta.models.dto.ProntuarioDTO;
import com.bandtec.mais.consulta.models.dto.response.PacienteInfoResponseDTO;
import com.bandtec.mais.consulta.usecase.patient.GetPacienteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GetPacienteInfoImpl implements GetPacienteInfo {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private RemedioRepository remedioRepository;

    @Autowired
    private DoencaRepository doencaRepository;

    @Autowired
    private DeficienciaRepository deficienciaRepository;

    @Autowired
    private AlergiaRepository alergiaRepository;

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Override
    public Optional<PacienteInfoResponseDTO> execute(Integer idPaciente) {

        if (pacienteRepository.existsByIdPaciente(idPaciente)) {

            Paciente paciente = pacienteRepository.findById(idPaciente).get();

            Usuario usuario = paciente.getUsuario();
            Endereco endereco = paciente.getEndereco();

            List<Doenca> doencaList = doencaRepository.findByPacienteId(idPaciente);
            List<Alergia> alergiaList = alergiaRepository.findByPacienteId(idPaciente);
            List<Deficiencia> deficienciaList = deficienciaRepository.findByPacienteId(idPaciente);
            List<Remedio> remedioList = remedioRepository.findByPacienteId(idPaciente);
            List<Atividade> atividadeList = atividadeRepository.findByPacienteId(idPaciente);

            List<Doenca> doencaHereditariaList = doencaList.stream().filter(Doenca::getHereditaria).collect(Collectors.toList());
            List<Doenca> doencaCronicaList = doencaList.stream().filter(Doenca::getCronico).collect(Collectors.toList());
            List<Doenca> doencaDSTList = doencaList.stream().filter(Doenca::getDst).collect(Collectors.toList());
            List<Remedio> remedioControladoList = remedioList.stream().filter(Remedio::getControlado).collect(Collectors.toList());

            DadosPessoaisDTO dadosPessoaisDTO = DadosPessoaisDTO
                    .builder()
                    .idPaciente(idPaciente)
                    .nome(paciente.getNome())
                    .idade(calcularIdade(paciente.getDtNascimento()))
                    .endereco(endereco.getRua())
                    .logradouro(endereco.getLogradouro())
                    .complemento(endereco.getComplemento())
                    .numero(endereco.getNumero())
                    .bairro(endereco.getBairro())
                    .numeroSus(paciente.getNumeroCarteiraSus())
                    .cpf(usuario.getCpf())
                    .telefone(paciente.getTelefone())
                    .cidade(endereco.getCidade())
                    .estado(endereco.getEstado())
                    .celular(paciente.getTelefone())
                    .cep(endereco.getCep())
                    .build();

            ProntuarioDTO prontuarioDTO = ProntuarioDTO
                    .builder()
                    .peso(paciente.getPeso())
                    .altura(paciente.getAltura())
                    .doencasCronicas(doencaCronicaList)
                    .remediosControlados(remedioControladoList)
                    .alergias(alergiaList)
                    .dsts(doencaDSTList)
                    .isFumante(paciente.getIsFumante())
                    .isVirgem(paciente.getIsVirgem())
                    .deficiencia(deficienciaList)
                    .doencasHereditarias(doencaHereditariaList)
                    .atividadesProibidas(atividadeList)
                    .tipoSanguineo(paciente.getTipoSanguineo())
                    .build();

            PacienteInfoResponseDTO pacienteInfoResponseDTO = PacienteInfoResponseDTO
                    .builder()
                    .dadosPessoais(dadosPessoaisDTO)
                    .prontuario(prontuarioDTO)
                    .build();

            return Optional.of(pacienteInfoResponseDTO);
        }

        return Optional.empty();
    }

    public static int calcularIdade(final LocalDate aniversario) {
        return Period.between(aniversario, LocalDate.now()).getYears();
    }

}
