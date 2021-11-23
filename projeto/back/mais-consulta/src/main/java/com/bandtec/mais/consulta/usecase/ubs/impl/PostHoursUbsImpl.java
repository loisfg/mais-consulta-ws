package com.bandtec.mais.consulta.usecase.ubs.impl;

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



    @Override
    public LocalDate execute(Integer idUbs) {





        return null;
    }
}
