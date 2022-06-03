package com.bandtec.mais.consulta.usecase.export.impl;


import com.bandtec.mais.consulta.gateway.repository.SchedulingRepository;
import com.bandtec.mais.consulta.gateway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class ExportSchedulingTxt implements ExportTxt {

    @Autowired
    private SchedulingRepository schedulingRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<Map<String, String>> execute(Integer userId, Integer schedulingId) {
        return Optional.empty();
    }
}
