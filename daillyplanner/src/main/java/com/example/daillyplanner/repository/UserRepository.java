package com.example.daillyplanner.repository;

import com.example.daillyplanner.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User,Integer> {
}
