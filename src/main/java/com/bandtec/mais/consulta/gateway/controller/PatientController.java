package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.domain.Clinic;
import com.bandtec.mais.consulta.domain.Patient;
import com.bandtec.mais.consulta.domain.User;
import com.bandtec.mais.consulta.models.dto.PersonalDataDTO;
import com.bandtec.mais.consulta.models.dto.request.PatientInfoPutRequestDTO;
import com.bandtec.mais.consulta.models.dto.request.SignUpPatientRequestDTO;
import com.bandtec.mais.consulta.models.dto.response.PatientHistoricMobileResponseDTO;
import com.bandtec.mais.consulta.models.dto.response.PatientHistoricResponseDTO;
import com.bandtec.mais.consulta.models.dto.response.PatientInfoResponseDTO;
import com.bandtec.mais.consulta.models.dto.response.PatientSchedulingResponseDTO;
import com.bandtec.mais.consulta.usecase.auth.PatientSignUp;
import com.bandtec.mais.consulta.usecase.clinic.GetClinic;
import com.bandtec.mais.consulta.usecase.patient.*;
import com.bandtec.mais.consulta.usecase.patient.impl.GetHistoricMobileImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("paciente")
public class PatientController {

    private final List<User> connectedUsers;

    public PatientController() {
        this.connectedUsers = new ArrayList<>();
    }

    @Autowired
    private GetClinic getClinic;

    @Autowired
    private PatientSignUp patientSignUp;

    @Autowired
    private GetSchedule getSchedule;

    @Autowired
    private GetPatientInfo getPatientInfo;

    @Autowired
    private GetPatientInfoMobile getPatientInfoMobile;

    @Autowired
    private GetHistoric getHistoric;

    @Autowired
    private PutPatientInfo putPatientInfo;

    @Autowired
    private GetHistoricMobileImpl getHistoricMobile;

    @GetMapping("/{patientId}")
    public ResponseEntity<PatientInfoResponseDTO> getPatientInfo(@PathVariable Integer patientId) {
        return ResponseEntity.of(getPatientInfo.execute(patientId));
    }

    @GetMapping("/mobile/{patientId}")
    public ResponseEntity<PersonalDataDTO> getPatientInfoMobile(@PathVariable Integer patientId) {
        return ResponseEntity.of(getPatientInfoMobile.execute(patientId));
    }

    @PostMapping("/signup")
    public ResponseEntity<User> patientSignUp(@RequestBody SignUpPatientRequestDTO signUpPatientRequestDTO) {

        Optional<User> oUser = patientSignUp.execute(signUpPatientRequestDTO);

        return oUser
                .map(it -> ResponseEntity.status(HttpStatus.CREATED).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @GetMapping("/agenda/{patientId}")
    public ResponseEntity<List<PatientSchedulingResponseDTO>> getPatientSchedule(@PathVariable Integer patientId,
                                                                                 @RequestHeader(value = "dtStart") String startDate,
                                                                                 @RequestHeader(value = "dtEnd") String endDate
    ) {
        Optional<List<PatientSchedulingResponseDTO>> oSchedule = getSchedule.execute(patientId, startDate, endDate);

        return oSchedule
                .map(it -> ResponseEntity.status(HttpStatus.OK).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @GetMapping("/historico/{patientId}")
    public ResponseEntity<List<PatientHistoricResponseDTO>> getPatientHistoric(@PathVariable Integer patientId) {

        Optional<List<PatientHistoricResponseDTO>> oHistoric = getHistoric.execute(patientId);

        return oHistoric
                .map(it -> ResponseEntity.status(HttpStatus.OK).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @GetMapping("/historicos/{patientId}")
    public ResponseEntity<List<PatientHistoricMobileResponseDTO>> getPatientHistoricMobile(@PathVariable Integer patientId) {

        Optional<List<PatientHistoricMobileResponseDTO>> oHistoric = getHistoricMobile.execute(patientId);

        return oHistoric
                .map(it -> ResponseEntity.status(HttpStatus.OK).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @GetMapping("/mapa/{patientId}")
    public ResponseEntity<List<Clinic>> getClinicByLocalization(@PathVariable Integer patientId) {
        return ResponseEntity.of(getClinic.execute(patientId));
    }

    @PutMapping("{patientId}")
    public ResponseEntity<Patient> putPatientInfos(@PathVariable Integer patientId,
                                                   @RequestBody PatientInfoPutRequestDTO patientInfoPutRequestDTO) {
        ResponseEntity.of(putPatientInfo.execute(patientId, patientInfoPutRequestDTO));

        return null;
    }
}
