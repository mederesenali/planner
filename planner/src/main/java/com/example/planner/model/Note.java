package com.example.planner.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Entity
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String title;
    @NotBlank
    private String content;
  //  @Builder.Default
    private Boolean done;
    @OrderBy("DESC")
    private LocalDate localDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;
}
