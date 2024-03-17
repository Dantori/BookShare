package ru.trofimov.bookshare.service;

import ru.trofimov.bookshare.domain.user.User;

import java.util.List;

public interface UserService {

    void addUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    void updateUser(User user, Long id);
    void deleteUserById(Long id);
}
