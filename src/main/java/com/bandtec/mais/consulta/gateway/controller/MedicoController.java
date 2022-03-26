package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.domain.Doctor;
import com.bandtec.mais.consulta.domain.DoctorImportExport;
import com.bandtec.mais.consulta.domain.Ubs;
import com.bandtec.mais.consulta.domain.User;
import com.bandtec.mais.consulta.gateway.repository.EspecialidadeRepository;
import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.gateway.repository.UbsRepository;
import com.bandtec.mais.consulta.gateway.repository.UsuarioRepository;
import com.bandtec.mais.consulta.models.dto.request.SignUpDoctorRequestDTO;
import com.bandtec.mais.consulta.models.dto.request.PatientInfoRequestDTO;
import com.bandtec.mais.consulta.models.dto.response.DoctorSchedulingDTO;
import com.bandtec.mais.consulta.models.dto.response.DoctorHistoricResponseDTO;
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
    public Optional<User> medicoimport(@RequestBody SignUpDoctorRequestDTO signUpDoctorRequestDTO){

        Optional<Ubs> ubs = ubsRepository.findById(signUpDoctorRequestDTO.getUbsId());

        Doctor doctor = signUpDoctorRequestDTO.getDoctor();
        User user = User
                .builder()
                .cpf(signUpDoctorRequestDTO.getCpf())
                .email(signUpDoctorRequestDTO.getEmail())
                .password(signUpDoctorRequestDTO.getPassword())
                .role(signUpDoctorRequestDTO.getRole())
                .build();

        if (usuarioRepository.existsByCpf(user.getCpf())) {
            log.info("Usuario já existente");
            return Optional.empty();
        } else {
            System.out.println(signUpDoctorRequestDTO);
            List<SignUpDoctorRequestDTO> medicoList = new ArrayList<>();
            DoctorImportExport doctorImportExport = new DoctorImportExport();

            medicoList.add(signUpDoctorRequestDTO);

            boolean existsEspecialidade = especialidadeRepository.existsByDescricao(doctor.getSpecialty().getDescription());
            if (existsEspecialidade) {
                doctor.setSpecialty(especialidadeRepository.findByDescricao(doctor.getSpecialty().getDescription()));
            }
            ubs.ifPresent(doctor::setUbs);
            doctor.setUser(user);
            medicoRepository.save(doctor);
            System.out.println("medico"+ doctor);
            List<Doctor> doctorList1 = medicoRepository.findAllMedicos();

            doctorImportExport.recordTxtFile(doctorList1);
            return Optional.of(usuarioRepository.save(user));

        }
    }


    @PostMapping("{idMedico}/{idPaciente}/{idAgendamento}/atendimento")
    public ResponseEntity<?> editarFormularioAtendimento(@PathVariable Integer idMedico,
                                                         @PathVariable Integer idPaciente,
                                                         @PathVariable Integer idAgendamento,
                                                         @RequestBody PatientInfoRequestDTO patientInfoRequestDTO) {
        return ResponseEntity.of(postFormularioAtendimento.execute(idMedico, idPaciente, idAgendamento, patientInfoRequestDTO));
    }

    @PostMapping("/signup")
    public ResponseEntity<User> medicoSignUp(@RequestBody SignUpDoctorRequestDTO signUpDoctorRequestDTO) {

        Optional<User> oUsuario = medicoSignup.execute(signUpDoctorRequestDTO);

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
    public ResponseEntity<List<DoctorSchedulingDTO>> getAgendamentosByMedico(@PathVariable Integer idMedico) {
        Optional<List<DoctorSchedulingDTO>> oAgendamentos = medicoAgendamentos.execute(idMedico);
        validation.verifyMedicoExists(idMedico);

        return oAgendamentos
                .map(it -> ResponseEntity.status(HttpStatus.OK).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @GetMapping("/{idMedico}/historico")
    public ResponseEntity<List<DoctorHistoricResponseDTO>> getHistoricoByMedico(@PathVariable Integer idMedico) {
        Optional<List<DoctorHistoricResponseDTO>> oHistorico = medicoHistorico.execute(idMedico);
        validation.verifyMedicoExists(idMedico);

        return oHistorico
                .map(it -> ResponseEntity.status(HttpStatus.OK).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

}
