package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.domain.MedicoImportEexport;
import com.bandtec.mais.consulta.domain.Ubs;
import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.gateway.repository.EspecialidadeRepository;
import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.gateway.repository.UbsRepository;
import com.bandtec.mais.consulta.gateway.repository.UsuarioRepository;
import com.bandtec.mais.consulta.models.dto.request.MedicoSignUpRequestDTO;
import com.bandtec.mais.consulta.models.dto.request.PacienteInfoRequestDTO;
import com.bandtec.mais.consulta.models.dto.response.MedicoAgendamentoDTO;
import com.bandtec.mais.consulta.models.dto.response.MedicoHistoricoResponseDTO;
import com.bandtec.mais.consulta.usecase.auth.MedicoDelete;
import com.bandtec.mais.consulta.usecase.auth.MedicoSignUp;
import com.bandtec.mais.consulta.usecase.doctor.MedicoHistorico;
import com.bandtec.mais.consulta.usecase.doctor.PostFormularioAtendimento;
import com.bandtec.mais.consulta.usecase.doctor.MedicoAgendamentos;
import com.bandtec.mais.consulta.validation.Validation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("medico")
public class MedicoController {

    @Autowired
    private MedicoSignUp medicoSignup;

    @Autowired
    private MedicoDelete medicoDelete;

    @Autowired
    private MedicoAgendamentos medicoAgendamentos;

    @Autowired
    private MedicoHistorico medicoHistorico;

    @Autowired
    private Validation validation;

    @Autowired
    private PostFormularioAtendimento postFormularioAtendimento;

    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private UbsRepository ubsRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @PostMapping("import")
    public Optional<Usuario> medicoimport(@RequestBody MedicoSignUpRequestDTO medicoSignUpRequestDTO){

        Optional<Ubs> ubs = ubsRepository.findById(medicoSignUpRequestDTO.getIdUbs());

        Medico medico = medicoSignUpRequestDTO.getMedico();
        Usuario usuario = Usuario
                .builder()
                .cpf(medicoSignUpRequestDTO.getCpf())
                .email(medicoSignUpRequestDTO.getEmail())
                .password(medicoSignUpRequestDTO.getPassword())
                .role(medicoSignUpRequestDTO.getRole())
                .build();

        if (usuarioRepository.existsByCpf(usuario.getCpf())) {
            log.info("Usuario já existente");
            return Optional.empty();
        } else {
            System.out.println(medicoSignUpRequestDTO);
            List<MedicoSignUpRequestDTO> medicoList = new ArrayList<>();
            MedicoImportEexport medicoImportEexport = new MedicoImportEexport();

            medicoList.add(medicoSignUpRequestDTO);

            boolean existsEspecialidade = especialidadeRepository.existsByDescricao(medico.getEspecialidade().getDescricao());
            if (existsEspecialidade) {
                medico.setEspecialidade(especialidadeRepository.findByDescricao(medico.getEspecialidade().getDescricao()));
            }
            ubs.ifPresent(medico::setUbs);
            medico.setUsuario(usuario);
            medicoRepository.save(medico);
            System.out.println("medico"+medico);
            List<Medico> medicoList1 = medicoRepository.findAllMedicos();

            medicoImportEexport.gravaArquivoTxt(medicoList1);
            return Optional.of(usuarioRepository.save(usuario));

        }
    }


    @PostMapping("{idMedico}/{idPaciente}/{idAgendamento}/atendimento")
    public ResponseEntity<?> editarFormularioAtendimento(@PathVariable Integer idMedico,
                                                         @PathVariable Integer idPaciente,
                                                         @PathVariable Integer idAgendamento,
                                                         @RequestBody PacienteInfoRequestDTO pacienteInfoRequestDTO) {
        return ResponseEntity.of(postFormularioAtendimento.execute(idMedico, idPaciente, idAgendamento, pacienteInfoRequestDTO));
    }

    @PostMapping("/signup")
    public ResponseEntity<Usuario> medicoSignUp(@RequestBody MedicoSignUpRequestDTO medicoSignUpRequestDTO) {

        Optional<Usuario> oUsuario = medicoSignup.execute(medicoSignUpRequestDTO);

        return oUsuario
                .map(it -> ResponseEntity.status(HttpStatus.CREATED).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> medicoDelete(@PathVariable Integer id) {
        validation.verifyMedicoExists(id);
        if (medicoDelete.execute(id)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{idMedico}/agendamentos")
    public ResponseEntity<List<MedicoAgendamentoDTO>> getAgendamentosByMedico(@PathVariable Integer idMedico) {
        Optional<List<MedicoAgendamentoDTO>> oAgendamentos = medicoAgendamentos.execute(idMedico);
        validation.verifyMedicoExists(idMedico);

        return oAgendamentos
                .map(it -> ResponseEntity.status(HttpStatus.OK).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @GetMapping("/{idMedico}/historico")
    public ResponseEntity<List<MedicoHistoricoResponseDTO>> getHistoricoByMedico(@PathVariable Integer idMedico) {
        Optional<List<MedicoHistoricoResponseDTO>> oHistorico = medicoHistorico.execute(idMedico);
        validation.verifyMedicoExists(idMedico);

        return oHistorico
                .map(it -> ResponseEntity.status(HttpStatus.OK).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

}
