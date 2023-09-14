package com.example.librabymanagementsystem.model;

import com.example.librabymanagementsystem.Enum.TransactionStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String TransactionNumber;

    @CreationTimestamp
    Date TransactionTime;

    TransactionStatus transactionStatus;

    // tranasaction to book
    //many to one
    @ManyToOne
    @JoinColumn
    Book book;


    //tranction to librarycard
    //m to 1
    @ManyToOne
    @JoinColumn
    LibraryCard libraryCard;



}
