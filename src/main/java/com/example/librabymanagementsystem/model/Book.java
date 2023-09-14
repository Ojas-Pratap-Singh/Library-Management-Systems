package com.example.librabymanagementsystem.model;

import com.example.librabymanagementsystem.Enum.Genre;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title;
    int noOfPags;
    @Enumerated( EnumType.STRING)
    Genre genre;
    double cost;
    boolean isIssued;

    @ManyToOne
    @JoinColumn
    Author author;

    //book to taranction
    // 1 to many
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    List<Transaction> transactions = new ArrayList<>();

}
