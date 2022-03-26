package com.bandtec.mais.consulta.models.dto.request;

import com.bandtec.mais.consulta.domain.Address;
import com.bandtec.mais.consulta.domain.Ubs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Slf4j
public class UbsPostRequestDTO {
    private String name;
    private String phone;
    private Address address;

    public static Ubs convertFromController(UbsPostRequestDTO ubsPostRequestDTO) {
        log.debug("Creating UBS {}", ubsPostRequestDTO);
        return Ubs
                .builder()
                .name(ubsPostRequestDTO.name)
                .address(ubsPostRequestDTO.address)
                .phone(ubsPostRequestDTO.phone)
                .build();
    }
}
