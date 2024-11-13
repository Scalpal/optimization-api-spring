package com.exo1.exo1.repository;

import com.exo1.exo1.dto.ProjectDto;
import com.exo1.exo1.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;


public interface ProjectRepository extends JpaRepository<Project, Long> {
}
