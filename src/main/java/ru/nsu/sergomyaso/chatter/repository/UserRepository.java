package ru.nsu.sergomyaso.chatter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.sergomyaso.chatter.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
