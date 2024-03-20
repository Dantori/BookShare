package ru.trofimov.bookshare.web.security.service;

import ru.trofimov.bookshare.web.security.dto.LoginResponse;
import ru.trofimov.bookshare.web.security.dto.LoginRequest;

public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);
}
