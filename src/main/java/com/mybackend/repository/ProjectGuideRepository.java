package com.mybackend.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mybackend.entity.ProjectGuide;

public interface ProjectGuideRepository extends JpaRepository<ProjectGuide, Long> {
}

