package com.example.librabymanagementsystem.service;

import com.example.librabymanagementsystem.exception.AuthorNotFoundException;
import com.example.librabymanagementsystem.model.Author;
import com.example.librabymanagementsystem.model.Book;
import com.example.librabymanagementsystem.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    AuthorRepository authorRepository;
    public String addBook(Book book) {
        //checking if author is present which has written this book (in author input in book)
        Optional<Author> optionalAuthor = authorRepository.findById(book.getAuthor().getId());
        if(optionalAuthor.isEmpty()){
             throw new AuthorNotFoundException("invalid author id");
        }
        Author author = optionalAuthor.get();
        book.setAuthor(author);
        author.getBook().add(book);
        authorRepository.save(author); // save botj ahtor and book as author is parent class
        return " book saved successfully";

    }
}
