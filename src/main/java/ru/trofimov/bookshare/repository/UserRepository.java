package ru.trofimov.bookshare.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.trofimov.bookshare.domain.user.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}