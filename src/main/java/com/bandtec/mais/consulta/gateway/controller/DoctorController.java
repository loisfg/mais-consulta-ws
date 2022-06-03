package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.domain.Doctor;
import com.bandtec.mais.consulta.domain.DoctorImportExport;
import com.bandtec.mais.consulta.domain.Clinic;
import com.bandtec.mais.consulta.domain.User;
import com.bandtec.mais.consulta.gateway.repository.SpecialtyRepository;
import com.bandtec.mais.consulta.gateway.repository.DoctorRepository;
import com.bandtec.mais.consulta.gateway.repository.ClinicRepository;
import com.bandtec.mais.consulta.gateway.repository.UserRepository;
import com.bandtec.mais.consulta.models.dto.request.SignUpDoctorRequestDTO;
import com.bandtec.mais.consulta.models.dto.request.PatientInfoRequestDTO;
import com.bandtec.mais.consulta.models.dto.response.DoctorSchedulingDTO;
import com.bandtec.mais.consulta.models.dto.response.DoctorHistoricResponseDTO;
import com.bandtec.mais.consulta.usecase.auth.DoctorDelete;
import com.bandtec.mais.consulta.usecase.auth.DoctorSignUp;
import com.bandtec.mais.consulta.usecase.doctor.DoctorHistoric;
import com.bandtec.mais.consulta.usecase.doctor.PostTreatmentForm;
import com.bandtec.mais.consulta.usecase.doctor.DoctorSchedules;
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
public class DoctorController {

    @Autowired
    private DoctorSignUp doctorSignUp;

    @Autowired
    private DoctorDelete doctorDelete;

    @Autowired
    private DoctorSchedules doctorSchedules;

    @Autowired
    private DoctorHistoric doctorHistoric;

    @Autowired
    private Validation validation;

    @Autowired
    private PostTreatmentForm postTreatmentForm;

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private ClinicRepository clinicRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SpecialtyRepository specialtyRepository;

    @PostMapping("import")
    public Optional<User> doctorImport(@RequestBody SignUpDoctorRequestDTO signUpDoctorRequestDTO) {

        Optional<Clinic> clinic = clinicRepository.findById(signUpDoctorRequestDTO.getClinicId());

        Doctor doctor = signUpDoctorRequestDTO.getDoctor();
        User user = User
                .builder()
                .cpf(signUpDoctorRequestDTO.getCpf())
                .email(signUpDoctorRequestDTO.getEmail())
                .password(signUpDoctorRequestDTO.getPassword())
                .role(signUpDoctorRequestDTO.getRole())
                .build();

        if (userRepository.existsByCpf(user.getCpf())) {
            log.info("User already exist");
            return Optional.empty();
        } else {
            System.out.println(signUpDoctorRequestDTO);
            List<SignUpDoctorRequestDTO> doctorList = new ArrayList<>();
            DoctorImportExport doctorImportExport = new DoctorImportExport();

            doctorList.add(signUpDoctorRequestDTO);

            boolean existsSpecialties = specialtyRepository.existsByDescription(doctor.getSpecialty().getDescription());
            if (existsSpecialties) {
                doctor.setSpecialty(specialtyRepository.findByDescription(doctor.getSpecialty().getDescription()));
            }
            clinic.ifPresent(doctor::setClinic);
            doctor.setUser(user);
            doctorRepository.save(doctor);
            System.out.println("medico" + doctor);
            List<Doctor> doctorList1 = doctorRepository.findAllDoctors();

            doctorImportExport.recordTxtFile(doctorList1);
            return Optional.of(userRepository.save(user));

        }
    }


    @PostMapping("{doctorId}/{patientId}/{schedulingId}/atendimento")
    public ResponseEntity<?> editTreatmentForm(@PathVariable Integer doctorId,
                                               @PathVariable Integer patientId,
                                               @PathVariable Integer schedulingId,
                                               @RequestBody PatientInfoRequestDTO patientInfoRequestDTO) {
        return ResponseEntity.of(postTreatmentForm.execute(doctorId, patientId, schedulingId, patientInfoRequestDTO));
    }

    @PostMapping("/signup")
    public ResponseEntity<User> doctorSignUp(@RequestBody SignUpDoctorRequestDTO signUpDoctorRequestDTO) {

        Optional<User> oUser = doctorSignUp.execute(signUpDoctorRequestDTO);

        return oUser
                .map(it -> ResponseEntity.status(HttpStatus.CREATED).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> doctorDelete(@PathVariable Integer id) {
        validation.verifyDoctorExists(id);
        if (doctorDelete.execute(id)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{doctorId}/agendamentos")
    public ResponseEntity<List<DoctorSchedulingDTO>> getSchedulesByDoctor(@PathVariable Integer doctorId) {
        Optional<List<DoctorSchedulingDTO>> oSchedules = doctorSchedules.execute(doctorId);
        validation.verifyDoctorExists(doctorId);

        return oSchedules
                .map(it -> ResponseEntity.status(HttpStatus.OK).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @GetMapping("/{doctorId}/historico")
    public ResponseEntity<List<DoctorHistoricResponseDTO>> getHistoricByDoctor(@PathVariable Integer doctorId) {
        Optional<List<DoctorHistoricResponseDTO>> oHistoric = doctorHistoric.execute(doctorId);
        validation.verifyDoctorExists(doctorId);

        return oHistoric
                .map(it -> ResponseEntity.status(HttpStatus.OK).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

}
