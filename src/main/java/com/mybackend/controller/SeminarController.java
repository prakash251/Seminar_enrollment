package com.mybackend.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mybackend.entity.Seminar;
import com.mybackend.entity.SeminarList;
import com.mybackend.repository.SeminarListRepository;
import com.mybackend.service.SeminarListService;
import com.mybackend.service.SeminarService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/seminar")
public class SeminarController {

    private final SeminarService seminarService;
    private final SeminarListService seminarListService;
    private final SeminarListRepository seminarListRepository;
    private final Logger logger = LoggerFactory.getLogger(SeminarController.class);

    @Autowired
    public SeminarController(SeminarService seminarService, SeminarListService seminarListService, SeminarListRepository seminarListRepository) {
        this.seminarService = seminarService;
        this.seminarListService = seminarListService;
        this.seminarListRepository = seminarListRepository;
    }

    @GetMapping("")
    public List<Seminar> getSeminarByEmail(@RequestParam String email) {
        logger.info("Getting seminars by email: {}", email);
        return seminarService.getSeminarByEmail(email);
    }

    @GetMapping("/list")
    public List<SeminarList> getAllSeminars() {
        logger.info("Getting all seminars");
        return seminarListRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSeminar(@PathVariable Long id) {
        logger.info("Deleting seminar with ID: {}", id);
        seminarService.deleteSeminar(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("AdminDelete/{id}")
    public ResponseEntity<?> deleteAdminSeminar(@PathVariable Long id) {
        try {
            logger.info("Admin deleting seminar with ID: {}", id);
            seminarListService.deleteSeminarById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Failed to delete seminar: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete seminar.");
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addSeminarList(@RequestBody SeminarList seminarList) {
        try {
            SeminarList seminarL = new SeminarList();
            seminarL.setSeminarId(seminarList.getSeminarId());
            seminarL.setDate(seminarList.getDate());
            seminarL.setLocation(seminarList.getLocation());
            seminarL.setMentorName(seminarList.getMentorName());
            seminarL.setFee(seminarList.getFee());

            // Save the new seminar
            seminarListService.addSeminarList(seminarL);

            logger.info("Added a new seminar: {}", seminarL);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Failed to add seminar: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add seminar.");
        }
    }

    @PostMapping("/enroll")
    public ResponseEntity<?> enroll(@RequestBody Seminar seminar) {
        seminarService.enroll(seminar.getEmail(), seminar.getDate(), seminar.getFee(), seminar.getLocation(), seminar.getMentorName(), seminar.getSeminarId());
        logger.info("Enrolled student for seminar with ID: {}", seminar.getSeminarId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/attend/{id}")
    public ResponseEntity<Seminar> attendSeminar(@RequestParam String id) {
        Long Longid = Long.parseLong(id);
        Seminar seminar = seminarService.getSeminarById(Longid);
        logger.info("Retrieved seminar details for ID: {}", Longid);
        return new ResponseEntity<>(seminar, HttpStatus.OK);
    }
}