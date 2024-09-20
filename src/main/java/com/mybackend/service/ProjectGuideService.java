package com.mybackend.service;



import java.util.List;

import com.mybackend.entity.ProjectGuide;

public interface ProjectGuideService {
    List<ProjectGuide> getAllProjectGuides();
    ProjectGuide addProjectGuide(ProjectGuide projectGuide);
    void removeProjectGuide(Long id);
}

