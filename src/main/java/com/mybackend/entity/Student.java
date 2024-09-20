package com.mybackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;
    
    @Column(name="role")
    private String role;
    
    // constructors, getters, and setters
    
 public Student(String email, String password, String role) {
  super();
  this.email = email;
  this.password = password;
  this.role = role;
 }
 public Student() {
  super();
  // TODO Auto-generated constructor stub
 }
 public Long getId() {
  return id;
 }
 public String getEmail() {
  return email;
 }
 public String getPassword() {
  return password;
 }
 public String getRole() {
  return role;
 }
 public void setId(Long id) {
  this.id = id;
 }
 public void setEmail(String email) {
  this.email = email;
 }
 public void setPassword(String password) {
  this.password = password;
 }
 public void setRole(String role) {
  this.role= role;
 }
	
}
