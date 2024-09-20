package com.mybackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.mybackend.entity.Student;

@EnableJpaRepositories
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

 Student findByEmail(String email);

 Student findByEmailAndPassword(String email, String password);
  @Query("SELECT s.email FROM Student s")
  List<String> findAllEmails();

 Student findByEmailAndPasswordAndRole(String email, String password, String role);
}