package ru.nsu.sergomyaso.chatter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.sergomyaso.chatter.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
