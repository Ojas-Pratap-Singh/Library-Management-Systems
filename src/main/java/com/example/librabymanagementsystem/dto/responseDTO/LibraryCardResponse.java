package com.example.librabymanagementsystem.dto.responseDTO;

import com.example.librabymanagementsystem.Enum.CardStatus;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibraryCardResponse {
    String cardNo;

    CardStatus cardStatus;

    Date issueDate;


}
