package com.example.librabymanagementsystem.controller;

import com.example.librabymanagementsystem.model.Author;
import com.example.librabymanagementsystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @PostMapping("/add")
    public ResponseEntity addAuthor(@RequestBody Author author){
        String response = authorService.addAuthor(author);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

}
