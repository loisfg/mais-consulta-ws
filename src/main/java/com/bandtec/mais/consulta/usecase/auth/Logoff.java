package com.bandtec.mais.consulta.usecase.auth;

import com.bandtec.mais.consulta.domain.User;

import java.util.List;
import java.util.Optional;

public interface Logoff {
    Optional<?> execute(Integer userId, List<User> connectedUsers);
}
