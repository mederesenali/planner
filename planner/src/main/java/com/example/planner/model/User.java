package com.example.planner.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
    private String name;
    private String email;
    private String password;
    @Builder.Default
    private boolean enabled=true;
    @Builder.Default
    private String role="USER";
}
