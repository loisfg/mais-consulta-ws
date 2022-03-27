package com.bandtec.mais.consulta.usecase.export.impl;

import com.bandtec.mais.consulta.domain.Scheduling;
import com.bandtec.mais.consulta.gateway.repository.SchedulingRepository;
import com.bandtec.mais.consulta.gateway.repository.UserRepository;
import com.bandtec.mais.consulta.usecase.export.ExportLastConsult;
import com.bandtec.mais.consulta.usecase.export.utils.BuildExportFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class ExportLastConsultImpl implements ExportLastConsult {

    @Autowired
    private SchedulingRepository schedulingRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<Map<String, String>> execute(Integer userId) {

        if (userRepository.existsById(userId)) {

            Optional<Scheduling> oScheduling = schedulingRepository.findFirstByPatient_User_UserIdOrderBySchedulingDateDesc(userId);

            if (oScheduling.isEmpty()) {
                return Optional.empty();
            }

            Map<String, String> dataSchedulingFile = BuildExportFile.buildDataSchedulingFile(oScheduling.get());

            return Optional.of(dataSchedulingFile);
        }

        return Optional.empty();
    }

}
