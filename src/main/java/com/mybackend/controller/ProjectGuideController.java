package com.mybackend.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mybackend.entity.ProjectGuide;
import com.mybackend.service.ProjectGuideService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/projectGuides")
public class ProjectGuideController {

    private final ProjectGuideService projectGuideService;
    private final Logger logger = LoggerFactory.getLogger(ProjectGuideController.class);

    @Autowired
    public ProjectGuideController(ProjectGuideService projectGuideService) {
        this.projectGuideService = projectGuideService;
    }

    @GetMapping
    public List<ProjectGuide> getAllProjectGuides() {
        logger.info("Getting all project guides");
        return projectGuideService.getAllProjectGuides();
    }

    @PostMapping("/add")
    public ProjectGuide addProjectGuide(@RequestBody ProjectGuide projectGuide) {
        logger.info("Adding a new project guide: {}", projectGuide);
        return projectGuideService.addProjectGuide(projectGuide);
    }

    @DeleteMapping("/{id}")
    public void removeProjectGuide(@PathVariable Long id) {
        logger.info("Removing project guide with ID: {}", id);
        projectGuideService.removeProjectGuide(id);
    }
}
