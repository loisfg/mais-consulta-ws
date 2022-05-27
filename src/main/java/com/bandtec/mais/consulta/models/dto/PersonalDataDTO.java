package com.bandtec.mais.consulta.models.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonalDataDTO {
    private String name;
    private Integer age;
    private String address;
    private String publicPlace;
    private String complement;
    private String number;
    private String district;
    private String rg;
    private String susNumber;
    private String cpf;
    private String phone;
    private String city;
    private String state;
    private String cellPhone;
    private String cep;
    private String email;
}
