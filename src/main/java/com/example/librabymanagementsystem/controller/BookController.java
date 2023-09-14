package com.example.librabymanagementsystem.controller;

import com.example.librabymanagementsystem.exception.AuthorNotFoundException;
import com.example.librabymanagementsystem.model.Book;
import com.example.librabymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody Book book){
        try {
            String response = bookService.addBook(book);
            return response;
        }
        catch (AuthorNotFoundException e){
            return e.getMessage();
        }
    }

}
