package com.mybackend.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mybackend.entity.Seminar;

public interface SeminarRepository extends JpaRepository<Seminar, Long> {

    Logger logger = LoggerFactory.getLogger(SeminarRepository.class);

    List<Seminar> findByEmail(String email);

    default List<Seminar> findByEmailWithLogging(String email) {
        logger.info("findByEmail() method called in SeminarRepository with email: {}", email);
        return findByEmail(email);
    }
}

