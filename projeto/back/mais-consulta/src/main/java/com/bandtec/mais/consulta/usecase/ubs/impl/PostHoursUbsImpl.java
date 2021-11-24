package com.bandtec.mais.consulta.usecase.ubs.impl;

import com.bandtec.mais.consulta.gateway.repository.AgendamentoRepository;
import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.models.dto.request.GetHorariosLivres;
import com.bandtec.mais.consulta.models.dto.response.HoursResponseDTO;
import com.bandtec.mais.consulta.usecase.ubs.PostHoursUbs;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        List<HoursResponseDTO> listHoursOcupeds = agendamentoRepository.findHrAndDtAtendimentoByIdUbs(getHorariosLivres.getIdUbs(), getHorariosLivres.getIdEspecialidade());
        List<Integer> medicos = medicoRepository.findIdsMedicosByIdEspecialidadeAndIdUbs(getHorariosLivres.getIdUbs(), getHorariosLivres.getIdEspecialidade());
        List<LocalTime> horariosTrabalho = addHours();
        List<LocalTime> horariosLivres = new ArrayList<>();

        listHoursOcupeds.forEach(ocupado -> {
            medicos.forEach(onUbs -> {
                if (!ocupado.getIdMedico().equals(onUbs)) {
                }
            });
        });


        return null;
    }

    @SneakyThrows
    public List<LocalTime> addHours() {
        LocalTime horas;
        List<LocalTime> allHours = null;
        int result = 0;

        for (int i = 9; i < 18; i++) {
            result = i % 2 == 0 ? 0 : 1;
            horas = LocalTime.of(i, result * 30);

            allHours.add(horas);
        }

        return allHours;
    }
}

/*
[ ] pegar datas/horarios disponiveis por ubs(dentro dos médicos da ubs) - tabela de Agendamento
 */