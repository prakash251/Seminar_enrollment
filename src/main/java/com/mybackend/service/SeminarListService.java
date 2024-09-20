package com.mybackend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybackend.entity.SeminarList;
import com.mybackend.repository.SeminarListRepository;

import java.util.List;

@Service
public class SeminarListService {
    
    private final SeminarListRepository seminarListRepository;
    private final Logger logger = LoggerFactory.getLogger(SeminarListService.class);

    @Autowired
    public SeminarListService(SeminarListRepository seminarListRepository) {
        this.seminarListRepository = seminarListRepository;
    }
    
    public List<SeminarList> getAllSeminars() {
        logger.info("Getting all seminars");
        return seminarListRepository.findAll();
    }

    public void deleteSeminarById(Long id) {
        logger.info("Deleting seminar with ID: {}", id);
        seminarListRepository.deleteById(id);
    }
    
    public void addSeminarList(SeminarList seminarList) {
        logger.info("Adding a new seminar: {}", seminarList);
        seminarListRepository.save(seminarList);
    }
}

