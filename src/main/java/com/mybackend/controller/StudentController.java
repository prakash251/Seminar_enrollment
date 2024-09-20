package com.mybackend.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mybackend.entity.Student;
import com.mybackend.service.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
 @Autowired 
 private StudentService studentService;
  private final Logger logger = LoggerFactory.getLogger(StudentController.class);

 @PostMapping("/register")
 public ResponseEntity<String> registerNewStudent(@RequestBody Student student) {
   logger.info("Registering a new student: {}", student.getEmail());
  try {
         studentService.addStudent(student);
         logger.info("Registration successful for email: {}", student.getEmail());
         return ResponseEntity.ok("Registration successful");
     } catch (DuplicateStudentException e) {
      logger.warn("User registration failed for email: {}", student.getEmail());
         return ResponseEntity.badRequest().body(e.getMessage());
     }
 }
    
    @PostMapping("/login")
    public ResponseEntity<?> AdminLoginValidation(@Validated @RequestBody Student student) {
     logger.info("Validating login for admin-email: {}", student.getEmail());
  return studentService.LoginValidation(student);
    }

    @GetMapping("/emails")
    public ResponseEntity<List<String>> getEmails() {
     logger.info("Getting all emails");
        List<String> emails = studentService.getEmails();
        return new ResponseEntity<>(emails, HttpStatus.OK);
    }
}