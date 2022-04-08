package com.bandtec.mais.consulta.usecase.export.impl;

import com.bandtec.mais.consulta.domain.Scheduling;
import com.bandtec.mais.consulta.gateway.repository.SchedulingRepository;
import com.bandtec.mais.consulta.gateway.repository.UserRepository;
import com.bandtec.mais.consulta.usecase.export.ExportConsultById;
import com.bandtec.mais.consulta.usecase.export.utils.BuildExportFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class ExportConsultByIdImpl implements ExportConsultById {
    @Autowired
    private SchedulingRepository schedulingRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<Map<String, String>> execute(Integer schedulingId, Integer userId) {

        if (userRepository.existsById(userId) && schedulingRepository.existsById(schedulingId)) {

            Optional<Scheduling> oScheduling = schedulingRepository.findBySchedulingId(schedulingId);

            if (oScheduling.isEmpty()) {
                return Optional.empty();
            }

            Map<String, String> dataSchedulingFile = BuildExportFile.buildDataSchedulingFile(oScheduling.get());

            return Optional.of(dataSchedulingFile);
        }

        return Optional.empty();
    }
}
