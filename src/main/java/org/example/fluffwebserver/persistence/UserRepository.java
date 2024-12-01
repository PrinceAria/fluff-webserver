package org.example.fluffwebserver.persistence;

import org.example.fluffwebserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
