package ru.trofimov.bookshare.web.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.trofimov.bookshare.domain.user.User;
import ru.trofimov.bookshare.service.UserService;
import ru.trofimov.bookshare.web.dto.UserDto;
import ru.trofimov.bookshare.web.mappre.UserMapper;
import ru.trofimov.bookshare.web.validation.OnCreate;
import ru.trofimov.bookshare.web.validation.OnUpdate;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "User controller", description = "User API")
@Validated
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/add_user")
    @Operation(summary = "Add user by id")
    public void addUser(@Validated(OnCreate.class) @RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        userService.addUser(user);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by id")
    public UserDto getUser(@PathVariable Long id) {
        return userMapper.toDto(userService.getUserById(id));
    }

    @GetMapping("/get_all_users")
    @Operation(summary = "Get all users")
    public List<UserDto> getAllUsers() {
        return userMapper.toDto(userService.getAllUsers());
    }

    @PostMapping("/update/{id}")
    @Operation(summary = "Update user by id")
    public void updateUser(@Validated(OnUpdate.class) @RequestBody UserDto userDto, @PathVariable Long id) {
        userService.updateUser(userMapper.toEntity(userDto), id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user by id")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}

