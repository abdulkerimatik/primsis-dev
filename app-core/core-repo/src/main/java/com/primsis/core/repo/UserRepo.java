package com.primsis.core.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.primsis.core.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    
}
