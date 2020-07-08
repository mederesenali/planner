package com.example.planner.service;

import com.example.planner.DTO.UserDTO;
import com.example.planner.exception.CustomerAlreadyRegisteredException;
import com.example.planner.model.User;
import com.example.planner.model.UserRegisterForm;
import com.example.planner.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private  final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public UserDTO register(UserRegisterForm form) throws CustomerAlreadyRegisteredException {
        if (userRepository.existsByEmail(form.getEmail())) {
            throw new CustomerAlreadyRegisteredException();
        }

        var user = User.builder()
                .email(form.getEmail())
                .name(form.getName())
                .password(encoder.encode(form.getPassword()))
                .build();

        userRepository.save(user);

        return UserDTO.from(user);
    }
}
