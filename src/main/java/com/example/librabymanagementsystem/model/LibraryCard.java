package com.example.librabymanagementsystem.model;

import com.example.librabymanagementsystem.Enum.CardStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String cardNo;
    CardStatus cardStatus;
    @CreationTimestamp
    Date issueDate;

    @OneToOne
    @JoinColumn    // for making foreign key in this table with primary key in parent table
    Student student;

    //lc to tramction
    //1 to m
    @OneToMany(mappedBy = "libraryCard",cascade = CascadeType.ALL)
    List<Transaction> transactions= new ArrayList<>();
}
