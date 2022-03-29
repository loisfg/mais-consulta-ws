package com.bandtec.mais.consulta.usecase.ubs.impl;

import com.bandtec.mais.consulta.gateway.repository.AgendamentoRepository;
import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.models.dto.response.HoursResponseDTO;
import com.bandtec.mais.consulta.usecase.ubs.PostHoursUbs;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class PostHoursUbsImpl implements PostHoursUbs {

    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    AgendamentoRepository agendamentoRepository;

    @SneakyThrows
    @Override
    public HashMap<String, List<LocalTime>> execute(Integer idUbs, String dia) {
        List<HoursResponseDTO> listHoursOcupeds = agendamentoRepository.findHrAndDtAtendimentoByIdUbs(idUbs, LocalDate.parse(dia));
        List<LocalTime> horariosTrabalho = addHours();
        LinkedHashMap<String, List<LocalTime>> horarios = new LinkedHashMap<>();
        List<LocalTime> horariosLivres = new ArrayList<>();
        List<LocalTime> horariosOcupados = new ArrayList<>();

        horariosTrabalho.forEach(horario -> {
            horariosLivres.add(horario);
            listHoursOcupeds.forEach(medicosOcupados -> {
                if (medicosOcupados.getDtAtendimento().equals(LocalDate.parse(dia))) {
                    if (medicosOcupados.getHrAtendimento().equals(horario)) {
                        horariosOcupados.add(horario);
                        horariosLivres.remove(horario);
                    }
                }
            });
        });

        horarios.put("Livre", horariosLivres);
        horarios.put("Ocupado", horariosOcupados);

        return horarios;
    }

    public List<LocalTime> addHours() {
        List<LocalTime> allHours = new ArrayList<>();
        List<Integer> hrs = List.of(8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18);
        try {
            for (Integer hr : hrs) {
                allHours.add(LocalTime.of(hr, 0));
                allHours.add(LocalTime.of(hr, 30));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return allHours;
    }
}