package com.mybackend.repository;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mybackend.entity.SeminarList;

public interface SeminarListRepository extends JpaRepository<SeminarList, Long> {

    Logger logger = LoggerFactory.getLogger(SeminarListRepository.class);

    List<SeminarList> findAll();

    default List<SeminarList> findAllWithLogging() {
        logger.info("findAll() method called in SeminarListRepository");
        return findAll();
    }
}
