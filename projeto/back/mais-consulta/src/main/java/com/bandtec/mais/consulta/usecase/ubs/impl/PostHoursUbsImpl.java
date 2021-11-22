package com.bandtec.mais.consulta.usecase.ubs.impl;

import com.bandtec.mais.consulta.domain.Data;
import com.bandtec.mais.consulta.domain.Hora;
import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.gateway.repository.DataRepository;
import com.bandtec.mais.consulta.gateway.repository.HoraRepository;
import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.usecase.ubs.PostHoursUbs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Stream;

@Service
public class PostHoursUbsImpl implements PostHoursUbs {

    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    DataRepository dataRepository;

    @Autowired
    HoraRepository horaRepository;

    @Override
    public LocalDate execute(Integer idUbs, Data data, Hora hora) {

        SimpleDateFormat sdf = new SimpleDateFormat();
        Set<Medico> medicosInUbs = medicoRepository.findMedicosByUbsId(idUbs);
        // TODO Fazer @Scheduler para por datas nesse repository;
//        Data datas = dataRepository.;
        Set<Hora> horas = horaRepository.findAllOrderByHoras();
        for (Hora h : horas ) {
            System.out.println(h);
            sdf.format(h.getHoras());
        }



        return null;
    }
}
