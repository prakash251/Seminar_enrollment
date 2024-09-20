package com.mybackend.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seminar")
public class Seminar {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column
    private String seminarId;
    @Column
    private String location;
    @Column
    private LocalDate date;
    @Column
    private String mentorName;
    @Column
    private Long fee;
    @Column 
    private String email;

	public Seminar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seminar(String seminarId, String location, LocalDate date, String mentorName, Long fee, String email) {
		super();
		this.seminarId = seminarId;
		this.location = location;
		this.date = date;
		this.mentorName = mentorName;
		this.fee = fee;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getSeminarId() {
		return seminarId;
	}

	public String getLocation() {
		return location;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getMentorName() {
		return mentorName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setSeminarId(String seminarId) {
		this.seminarId = seminarId;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}

	public Long getFee() {
		return fee;
	}

	public void setFee(Long fee) {
		this.fee = fee;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
}

