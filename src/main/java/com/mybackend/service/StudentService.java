package com.mybackend.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.mybackend.controller.DuplicateStudentException;
import com.mybackend.entity.Student;
import com.mybackend.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    private final Logger logger = LoggerFactory.getLogger(StudentService.class);
    
    public void addStudent(Student student) throws DuplicateStudentException {
     logger.info("Adding a new student: {}", student);
        if (studentRepository.findByEmail(student.getEmail()) != null) {
         logger.warn("User registration failed. User with email '{}' already exists.", student.getEmail());
            throw new DuplicateStudentException("User is already registered. Please login to the application.");
        }
        studentRepository.save(student);
        logger.info("User registration successful for email: {}", student.getEmail());
    }
    
    public List<String> getEmails() {
     logger.info("Getting all emails");
        return studentRepository.findAllEmails();
    }

// public ResponseEntity<?> LoginValidation(Student student) {
// Student authenticatedStudent = studentRepository.findByEmailAndPassword(student.getEmail(), student.getPassword());
// if (authenticatedStudent == null) {
// return ResponseEntity.badRequest().body("Invalid email or password.");
// }
//
// return ResponseEntity.ok("Login successful");
// }
	
    public ResponseEntity<?> LoginValidation(Student student) {
        Student authenticatedStudent = studentRepository.findByEmailAndPassword(student.getEmail(), student.getPassword());
        if (authenticatedStudent == null) {
            return ResponseEntity.badRequest().body("Invalid email or password.");
        }

        String role = authenticatedStudent.getRole();
        
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Login successful");
        response.put("role", role);

        return ResponseEntity.ok(response);
    }
}

