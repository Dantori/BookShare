package ru.trofimov.bookshare.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.trofimov.bookshare.domain.user.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findUserByUsername(String username);
}