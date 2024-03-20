package ru.trofimov.bookshare.web.security.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.trofimov.bookshare.repository.UserRepository;
import ru.trofimov.bookshare.web.security.dto.UserRegistrationDetails;

@Service
public class UserRegistrationDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserRegistrationDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username)
                .map(UserRegistrationDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found!"));
    }
}
