package com.exo1.exo1.service;

import com.exo1.exo1.dto.ProjectDto;
import com.exo1.exo1.entity.Project;

public interface ProjectService {
    String createProject(ProjectDto projectDto);

    Project getProject(Long id);

    String updateProject(Long id, ProjectDto projectDto);

    String deleteProject(Long id);
}
