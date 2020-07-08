package com.example.planner.DTO;

import com.example.planner.model.User;
import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
public class UserDTO {
    private int id;
    private String name;
    private String email;

    public static UserDTO from(User user) {
        return builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
