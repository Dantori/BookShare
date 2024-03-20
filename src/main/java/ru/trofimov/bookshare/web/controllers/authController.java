package ru.trofimov.bookshare.web.controllers;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.trofimov.bookshare.service.UserService;
import ru.trofimov.bookshare.web.dto.UserDto;
import ru.trofimov.bookshare.web.mappre.UserMapper;
import ru.trofimov.bookshare.web.security.dto.LoginRequest;
import ru.trofimov.bookshare.web.security.dto.LoginResponse;
import ru.trofimov.bookshare.web.validation.OnCreate;

@RestController
@RequestMapping("/auth")
@Validated
public class authController {

    private final UserService userService;
    private final UserMapper userMapper;
//    private final AuthService authService;

    public authController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/reg")
    public UserDto regUser(@Validated(OnCreate.class) @RequestBody UserDto userDto) {
        userService.addUser(userMapper.toEntity(userDto));
        return userMapper.toDto(userService.getUserByUsername(userDto.getUsername()));
    }

//    @PostMapping("/login")
//    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
//        return authService.login(loginRequest);
//    }
}
