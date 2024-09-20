package com.mybackend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybackend.entity.ProjectGuide;
import com.mybackend.repository.ProjectGuideRepository;

import java.util.List;

@Service
public class ProjectGuideServiceImpl implements ProjectGuideService {

    private final ProjectGuideRepository projectGuideRepository;
    private final Logger logger = LoggerFactory.getLogger(ProjectGuideServiceImpl.class);

    @Autowired
    public ProjectGuideServiceImpl(ProjectGuideRepository projectGuideRepository) {
        this.projectGuideRepository = projectGuideRepository;
    }

    @Override
    public List<ProjectGuide> getAllProjectGuides() {
        logger.info("Getting all project guides");
        return projectGuideRepository.findAll();
    }

    @Override
    public ProjectGuide addProjectGuide(ProjectGuide projectGuide) {
        logger.info("Adding a new project guide: {}", projectGuide);
        return projectGuideRepository.save(projectGuide);
    }

    @Override
    public void removeProjectGuide(Long id) {
        logger.info("Removing project guide with ID: {}", id);
        projectGuideRepository.deleteById(id);
    }
}
