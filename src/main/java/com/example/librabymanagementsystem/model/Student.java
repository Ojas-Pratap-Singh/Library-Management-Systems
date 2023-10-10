package com.example.librabymanagementsystem.model;

import com.example.librabymanagementsystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int regNo;
    String name;
    int age;
    @Column(unique = true)
    String mail;
    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    LibraryCard libraryCard;
}
