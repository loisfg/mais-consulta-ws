package com.bandtec.mais.consulta.models.dto.request;

import com.bandtec.mais.consulta.domain.Doctor;
import com.bandtec.mais.consulta.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Slf4j
public class SignUpDoctorRequestDTO {
    private String cpf;
    private String email;
    protected String password;
    private Doctor doctor;
    private Integer ubsId;
    private String role = "Medico";

    public static User convertFromController(SignUpDoctorRequestDTO signUpDoctorRequestDTO) {
        var user = User
                .builder()
                .cpf(signUpDoctorRequestDTO.getCpf())
                .email(signUpDoctorRequestDTO.getEmail())
                .password(signUpDoctorRequestDTO.getPassword())
                .role(signUpDoctorRequestDTO.getRole())
                .build();

        log.info("Converting request {} \n " +
                "to Doctor User {}", signUpDoctorRequestDTO, user);

        return user;
    }
}
