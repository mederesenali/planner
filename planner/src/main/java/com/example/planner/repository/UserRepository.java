package com.example.planner.repository;

import com.example.planner.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {
    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}
