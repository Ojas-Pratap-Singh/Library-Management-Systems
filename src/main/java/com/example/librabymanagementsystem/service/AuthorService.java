package com.example.librabymanagementsystem.service;

import com.example.librabymanagementsystem.model.Author;
import com.example.librabymanagementsystem.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public String addAuthor(Author author) {
      Author savedAuthor =  authorRepository.save(author);
      return "Author saved succeffully ";
    }
}
