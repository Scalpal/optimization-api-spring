package com.exo1.exo1.service.impl;

import com.exo1.exo1.dto.ProjectDto;
import com.exo1.exo1.entity.Project;
import com.exo1.exo1.mapper.ProjectMapper;
import com.exo1.exo1.repository.ProjectRepository;
import com.exo1.exo1.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Override
    public String createProject(ProjectDto projectDto) {
        Project project = projectMapper.toEntity(projectDto);

        projectRepository.save(project);

        return "Project created successfully";
    }

    @Override
    public Project getProject(Long id) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Project not found"));

        return project;
    }

    @Override
    public String updateProject(Long id, ProjectDto projectDto) {
        if(!projectRepository.existsById(id)) {
            throw new IllegalArgumentException("Project not found");
        }

        Project updatedProject = projectMapper.toEntity(projectDto);

        projectRepository.save(updatedProject);

        return "Project updated successfully";
    }

    @Override
    public String deleteProject(Long id) {
        if(!projectRepository.existsById(id)) {
            throw new IllegalArgumentException("Project not found");
        }

        projectRepository.deleteById(id);

        return "Project deleted successfully";
    }
}
