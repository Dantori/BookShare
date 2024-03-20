package ru.trofimov.bookshare.web.security.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import ru.trofimov.bookshare.domain.user.User;
import ru.trofimov.bookshare.service.UserService;
import ru.trofimov.bookshare.web.security.dto.LoginRequest;
import ru.trofimov.bookshare.web.security.dto.LoginResponse;
import ru.trofimov.bookshare.web.security.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    public AuthServiceImpl(AuthenticationManager authenticationManager, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @Override
    public LoginResponse login(final LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        ));
        User user = userService.getUserByUsername(loginRequest.getUsername());
        loginResponse.setId(user.getId());
        loginResponse.setUsername(user.getUsername());
        loginResponse.setRole(user.getRole());
        return loginResponse;
    }
}
