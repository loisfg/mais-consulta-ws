package com.bandtec.mais.consulta.models.dto.request;

import com.bandtec.mais.consulta.domain.Address;
import com.bandtec.mais.consulta.domain.Clinic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Slf4j
public class ClinicPostRequestDTO {
    private String name;
    private String phone;
    private Address address;

    public static Clinic convertFromController(ClinicPostRequestDTO clinicPostRequestDTO) {
        log.debug("Creating Clinic {}", clinicPostRequestDTO);
        return Clinic
                .builder()
                .name(clinicPostRequestDTO.name)
                .address(clinicPostRequestDTO.address)
                .phone(clinicPostRequestDTO.phone)
                .build();
    }
}
