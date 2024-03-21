package ru.trofimov.bookshare.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.trofimov.bookshare.domain.user.Role;
import ru.trofimov.bookshare.domain.user.User;
import ru.trofimov.bookshare.repository.UserRepository;
import ru.trofimov.bookshare.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        if (userRepository.findUserByUsername(user.getUsername()).isPresent()) {
            throw new IllegalStateException("User [" + user.getUsername() + "] already exists!");
        } else if (!user.getPassword().equals(user.getPasswordConfirm())) {
            throw new IllegalStateException("Password and password confirmation do not match!");
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole(Role.ROLE_USER);
            userRepository.save(user);
        }
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        Optional<User> userFromDB = userRepository.findById(id);
        return userFromDB
                .orElseThrow(() -> new EntityNotFoundException("User [" + id + "] not found!"));
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User [" + username + "] not found!"));
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    @Transactional
    public void updateUser(User user, Long id) {
        Optional<User> userFromDb = userRepository.findById(id);
        if (userFromDb.isPresent()) {
            userFromDb.get().setName(user.getName());
            userFromDb.get().setUsername(user.getUsername());
            userFromDb.get().setCity(user.getCity());
            userFromDb.get().setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(userFromDb.get());
        } else {
            throw new IllegalStateException("User [" + id + "] not exists!");
        }
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        Optional<User> userFromDB = userRepository.findById(id);
        if (userFromDB.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new IllegalStateException("User [" + id + "] not exists!");
        }
    }
}
