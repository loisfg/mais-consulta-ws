package com.bandtec.mais.consulta.usecase.patient.impl;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.gateway.repository.*;
import com.bandtec.mais.consulta.models.dto.PersonalDataDTO;
import com.bandtec.mais.consulta.models.dto.MedicalChartDTO;
import com.bandtec.mais.consulta.models.dto.response.PatientInfoResponseDTO;
import com.bandtec.mais.consulta.usecase.patient.GetPacienteInfo;
import lombok.SneakyThrows;
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
    public Optional<PatientInfoResponseDTO> execute(Integer idPaciente) {

        if (pacienteRepository.existsByIdPaciente(idPaciente)) {

            Patient patient = pacienteRepository.findById(idPaciente).get();

            User user = patient.getUser();
            Address address = patient.getAddress();

            List<Disease> diseaseList = doencaRepository.findByPacienteId(idPaciente);
            List<Allergy> allergyList = alergiaRepository.findByPacienteId(idPaciente);
            List<Deficiency> deficiencyList = deficienciaRepository.findByPacienteId(idPaciente);
            List<Medicine> medicineList = remedioRepository.findByPacienteId(idPaciente);
            List<Activity> activityList = atividadeRepository.findByPacienteId(idPaciente);

            List<Disease> diseaseHereditariaList = diseaseList.stream().filter(Disease::getHereditary).collect(Collectors.toList());
            List<Disease> diseaseCronicaList = diseaseList.stream().filter(Disease::getChronic).collect(Collectors.toList());
            List<Disease> diseaseDSTList = diseaseList.stream().filter(Disease::getStd).collect(Collectors.toList());
            List<Medicine> medicineControladoList = medicineList.stream().filter(Medicine::getControlled).collect(Collectors.toList());

            PersonalDataDTO personalDataDTO = PersonalDataDTO
                    .builder()
                    .name(patient.getName())
                    .age(calcularIdade(patient.getBirthDate()))
                    .address(address.getStreet())
                    .publicPlace(address.getPublicPlace())
                    .complement(address.getComplemento())
                    .number(address.getNumero())
                    .district(address.getDistrict())
                    .susNumber(patient.getSusNumberWallet())
                    .cpf(user.getCpf())
                    .phone(patient.getPhone())
                    .city(address.getCity())
                    .state(address.getState())
                    .cellPhone(patient.getPhone())
                    .cep(address.getZipCode())
                    .build();

            MedicalChartDTO medicalChartDTO = MedicalChartDTO
                    .builder()
                    .weight(patient.getWeight())
                    .height(patient.getHeight())
                    .chronicDiseases(diseaseCronicaList)
                    .prescriptionDrugs(medicineControladoList)
                    .allergies(allergyList)
                    .stds(diseaseDSTList)
                    .isSmoker(patient.getIsSmoker())
                    .isVirgin(patient.getIsVirgin())
                    .deficiency(deficiencyList)
                    .hereditaryDiseases(diseaseHereditariaList)
                    .prohibitedActivities(activityList)
                    .bloodType(patient.getBloodType())
                    .build();

            PatientInfoResponseDTO patientInfoResponseDTO = PatientInfoResponseDTO
                    .builder()
                    .personalData(personalDataDTO)
                    .medicalChart(medicalChartDTO)
                    .build();

            return Optional.of(patientInfoResponseDTO);
        }

        return Optional.empty();
    }

    @SneakyThrows
    public static int calcularIdade(final LocalDate aniversario) {
        return Period.between(aniversario, LocalDate.now()).getYears();
    }

}
