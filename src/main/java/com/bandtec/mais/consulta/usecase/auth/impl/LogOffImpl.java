package com.bandtec.mais.consulta.usecase.auth.impl;

import com.bandtec.mais.consulta.domain.User;
import com.bandtec.mais.consulta.usecase.auth.Logoff;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogOffImpl implements Logoff {
    @Override
    public Optional<?> execute(Integer userId, List<User> connectedUsers) {

        return connectedUsers.stream()
                .filter(it -> it.getUserId().equals(userId))
                .findFirst()
                .map(connectedUsers::remove);
    }
}
