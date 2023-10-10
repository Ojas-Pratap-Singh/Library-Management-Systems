package com.example.librabymanagementsystem.service;

import com.example.librabymanagementsystem.Enum.CardStatus;
import com.example.librabymanagementsystem.dto.requestDTO.StudentRequest;
import com.example.librabymanagementsystem.dto.responseDTO.LibraryCardResponse;
import com.example.librabymanagementsystem.dto.responseDTO.StudentResponse;
import com.example.librabymanagementsystem.model.LibraryCard;
import com.example.librabymanagementsystem.model.Student;
import com.example.librabymanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public StudentResponse addStudent(StudentRequest studentRequest) {
        //convert request dto to model   (by setting attrubutr in student from dto student request  )

//        Student student = new Student();
//        student.setName(studentRequest.getName());
//        student.setAge(studentRequest.getAge());
//        student.setMail(studentRequest.getMail());
//        student.setGender(studentRequest.getGender());

        //request dto to student model with builder
        Student student = Student.builder()
                .name(studentRequest.getName())
                .age(studentRequest.getAge())
                .mail(studentRequest.getMail())
                .gender(studentRequest.getGender())
                .build();

//        //give library card  (also setting library car no when student is added)
//        LibraryCard libraryCard = new LibraryCard();
//        libraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
//        libraryCard.setCardStatus(CardStatus.ACTIVE);
//        libraryCard.setStudent(student);

        //setting licard card no to student with builder
        LibraryCard libraryCard = LibraryCard.builder()
                .cardNo(String.valueOf(UUID.randomUUID()))
                .cardStatus(CardStatus.ACTIVE)
                .student(student)
                .build();

       student.setLibraryCard(libraryCard);

        Student saveStudent = studentRepository.save(student);

        //saved model to response dto and return it
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setName(saveStudent.getName());
        studentResponse.setEmail(saveStudent.getMail());
        studentResponse.setMessage("student has beed h=added succefuuly");


        //adding library card to student response

        LibraryCardResponse cardResponse = new LibraryCardResponse();
        cardResponse.setCardNo(saveStudent.getLibraryCard().getCardNo());
        cardResponse.setIssueDate(saveStudent.getLibraryCard().getIssueDate());
        cardResponse.setCardStatus(saveStudent.getLibraryCard().getCardStatus());
        studentResponse.setLibararyCardResponse(cardResponse);

        return studentResponse;

    }

    public Student getStudent(int regNo) {
        Optional<Student> optionalStudent =  studentRepository.findById(regNo);
        if(optionalStudent.isPresent()){
            return optionalStudent.get();
        }
        return null;
    }
}
