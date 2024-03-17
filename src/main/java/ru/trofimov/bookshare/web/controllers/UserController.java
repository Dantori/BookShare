package ru.trofimov.bookshare.web.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.trofimov.bookshare.domain.user.User;
import ru.trofimov.bookshare.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "User controller", description = "User API")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add_user")
    @Operation(summary = "Add user by id")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by id")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/get_all")
    @Operation(summary = "Get all users by id")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/{id}/update")
    @Operation(summary = "Update user by id")
    public void updateUser(@RequestBody User user, @PathVariable Long id) {
        userService.updateUser(user, id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user by id")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}

