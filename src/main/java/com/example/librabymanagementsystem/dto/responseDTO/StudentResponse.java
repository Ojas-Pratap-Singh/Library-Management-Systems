package com.example.librabymanagementsystem.dto.responseDTO;

import com.example.librabymanagementsystem.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    String name;

    String email;
    String message;
    String cardIssuedNo;

}