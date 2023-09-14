package com.example.librabymanagementsystem.controller;

import com.example.librabymanagementsystem.Enum.CardStatus;
import com.example.librabymanagementsystem.dto.requestDTO.StudentRequest;
import com.example.librabymanagementsystem.dto.responseDTO.StudentResponse;
import com.example.librabymanagementsystem.model.LibraryCard;
import com.example.librabymanagementsystem.model.Student;
import com.example.librabymanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody StudentRequest studentRequest){
        StudentResponse response = studentService.addStudent(studentRequest);
        return new ResponseEntity(response, HttpStatus.CREATED);

    }
    @GetMapping("/get")
    public ResponseEntity getStudent(@RequestParam("id") int regNo){
        Student student = studentService.getStudent(regNo);
        if(student!=null){
            return new ResponseEntity<>(student,HttpStatus.FOUND);
        }
        return new ResponseEntity("invald id",HttpStatus.BAD_REQUEST);
    }

}
