package com.brainstation_23.LibraryManagementSystem.repository;

import com.brainstation_23.LibraryManagementSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}