package com.bandtec.mais.consulta.usecase.doctor.impl;

import com.bandtec.mais.consulta.domain.Patient;
import com.bandtec.mais.consulta.gateway.repository.DoctorRepository;
import com.bandtec.mais.consulta.gateway.repository.PatientRepository;
import com.bandtec.mais.consulta.gateway.repository.SchedulingRepository;
import com.bandtec.mais.consulta.gateway.repository.UserRepository;
import com.bandtec.mais.consulta.models.dto.PersonalDataDTO;
import com.bandtec.mais.consulta.models.dto.request.DiagnosisDTO;
import com.bandtec.mais.consulta.models.dto.request.MedicalChartRequestDTO;
import com.bandtec.mais.consulta.models.dto.request.PatientInfoRequestDTO;
import com.bandtec.mais.consulta.models.enums.SchedulingStatusEnum;
import com.bandtec.mais.consulta.usecase.doctor.PostTreatmentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostSchedulingFormImpl implements PostTreatmentForm {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private SchedulingRepository schedulingRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<?> execute(Integer doctorId, Integer patientId, Integer schedulingId, PatientInfoRequestDTO patientInfoRequestDTO) {

        if (doctorRepository.existsByDoctorId(doctorId) && patientRepository.existsByPatientId(patientId)) {

            PersonalDataDTO personalDataDTO = patientInfoRequestDTO.getPersonalData();
            MedicalChartRequestDTO medicalChartDTO = patientInfoRequestDTO.getMedicalChart();
            DiagnosisDTO diagnosisDTO = patientInfoRequestDTO.getDiagnosis();

            if (patientRepository.existsById(patientId)) {

                Patient patient = patientRepository.findById(patientId).get();

                patient.setPatientId(patientId);
                patient.setName(personalDataDTO.getName());
                patient.setPhone(personalDataDTO.getPhone());
                patient.setWeight(medicalChartDTO.getWeight());
                patient.setHeight(medicalChartDTO.getHeight());

                patientRepository.save(patient);
                schedulingRepository.updateSchedulingStatus(schedulingId, SchedulingStatusEnum.FINISHED);

                return Optional.of(patient);
            }
        }
        return Optional.empty();
    }
}