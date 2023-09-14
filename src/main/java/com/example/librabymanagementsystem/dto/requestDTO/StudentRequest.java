package com.example.librabymanagementsystem.dto.requestDTO;

import com.example.librabymanagementsystem.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    String name;
    int age;

    String mail;

    Gender gender;
}
