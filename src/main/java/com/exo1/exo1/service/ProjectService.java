package com.exo1.exo1.service;

import com.exo1.exo1.dto.ProjectDto;
import com.exo1.exo1.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {
    String createProject(ProjectDto projectDto);

    Page<ProjectDto> getProjects(Pageable pageable);

    ProjectDto getProject(Long id);

    String updateProject(Long id, ProjectDto projectDto);

    String deleteProject(Long id);
}
