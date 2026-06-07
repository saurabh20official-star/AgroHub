package com.agrohub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agrohub.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}