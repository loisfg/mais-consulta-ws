package com.bandtec.mais.consulta.usecase.ubs.impl;

import com.bandtec.mais.consulta.gateway.repository.AgendamentoRepository;
import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.models.dto.request.GetHorariosLivres;
import com.bandtec.mais.consulta.models.dto.response.HoursResponseDTO;
import com.bandtec.mais.consulta.usecase.ubs.PostHoursUbs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostHoursUbsImpl implements PostHoursUbs {

    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    AgendamentoRepository agendamentoRepository;

    @Override
    public List<LocalTime> execute(GetHorariosLivres getHorariosLivres) {
        List<HoursResponseDTO> listHoursOcupeds = agendamentoRepository.findHrAndDtAtendimentoByIdUbs(getHorariosLivres.getIdUbs());
        List<LocalTime> horariosTrabalho = addHours();
        List<LocalTime> horariosLivres = new ArrayList<>();

        horariosTrabalho.forEach(hrTrabalho -> {
            horariosLivres.add(hrTrabalho);
            listHoursOcupeds.forEach(hrOcuped -> {
                        if (hrOcuped.getHrAtendimento().equals(hrTrabalho)
                        && hrOcuped.getDtAtendimento().equals(getHorariosLivres.getDia())) {
                            horariosLivres.remove(hrTrabalho);
                        }
                    }
            );
        });

        return horariosLivres;
    }

    public List<LocalTime> addHours() {
        LocalTime horas;
        List<LocalTime> allHours = new ArrayList<>();
        int result = 0;

        try {
            for (int i = 8; i < 18; i++) {
                result = i % 2 == 0 ? 0 : 1;
                horas = LocalTime.of(i, result * 30);

                allHours.add(horas);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return allHours;
    }
}