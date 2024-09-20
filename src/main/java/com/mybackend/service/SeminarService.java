package com.mybackend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mybackend.entity.Seminar;
import com.mybackend.repository.SeminarRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class SeminarService {
    private final SeminarRepository seminarRepository;
    private final Logger logger = LoggerFactory.getLogger(SeminarService.class);

    @Autowired
    public SeminarService(SeminarRepository seminarRepository) {
        this.seminarRepository = seminarRepository;
    }

    public List<Seminar> getSeminarByEmail(String email) {
        logger.info("Getting seminars by email: {}", email);
        return seminarRepository.findByEmail(email);
    }

    public Seminar getSeminarById(Long seminarId) {
        logger.info("Getting seminar by ID: {}", seminarId);
        return seminarRepository.findById(seminarId).orElse(null);
    }

    public void deleteSeminar(Long id) {
        logger.info("Deleting seminar with ID: {}", id);
        seminarRepository.deleteById(id);
    }

    public void enroll(String email, LocalDate date, Long fee, String location, String mentorName, String seminarId) {
        logger.info("Enrolling in a seminar: email={}, date={}, fee={}, location={}, mentorName={}, seminarId={}",
                email, date, fee, location, mentorName, seminarId);

        Seminar seminar = new Seminar();
        // Set the properties of the seminar object using the values passed in the parameters
        seminar.setEmail(email);
        seminar.setDate(date);
        seminar.setFee(fee);
        seminar.setLocation(location);
        seminar.setMentorName(mentorName);
        seminar.setSeminarId(seminarId);
        // Save the updated seminar object to the database
        seminarRepository.save(seminar);
        
        logger.info("Enrollment completed for seminar with ID: {}", seminarId);
    }
}
