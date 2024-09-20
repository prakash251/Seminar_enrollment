package com.mybackend.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seminar_list")
public class SeminarList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "fee")
    private Long fee;

    @Column(name = "location")
    private String location;

    @Column(name = "mentor_name")
    private String mentorName;

    @Column(name = "seminar_id")
    private String seminarId;

    public SeminarList() {}

    public SeminarList(LocalDate date, Long fee, String location, String mentorName, String seminarId) {
        this.date = date;
        this.fee = fee;
        this.location = location;
        this.mentorName = mentorName;
        this.seminarId = seminarId;
    }

	public Long getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}

	public Long getFee() {
		return fee;
	}

	public String getLocation() {
		return location;
	}

	public String getMentorName() {
		return mentorName;
	}

	public String getSeminarId() {
		return seminarId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setFee(Long fee) {
		this.fee = fee;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}

	public void setSeminarId(String seminarId) {
		this.seminarId = seminarId;
	}
    
}
