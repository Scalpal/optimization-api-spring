package com.exo1.exo1.service.impl;

import com.exo1.exo1.dto.ProjectDto;
import com.exo1.exo1.entity.Project;
import com.exo1.exo1.mapper.ProjectMapper;
import com.exo1.exo1.repository.ProjectRepository;
import com.exo1.exo1.repository.TasksPerProjectRepository;
import com.exo1.exo1.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService
{
    private final ProjectRepository projectRepository;
    private final TasksPerProjectRepository tasksPerProjectRepository;
    private final ProjectMapper projectMapper;

    @Override
    public String createProject(ProjectDto projectDto) {
        Project project = projectMapper.toEntity(projectDto);

        project.getTasks().stream().forEach((task) -> {
            task.setProject(project);
        });

        projectRepository.save(project);

        tasksPerProjectRepository.refreshTasksMaterializedView();

        return "Project created successfully";
    }

    @Override
    @Cacheable(value = "projects", key = "#id")
    public ProjectDto getProject(Long id) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Project not found"));

        return projectMapper.toDto(project);
    }

    @Override
    @Cacheable(value = "projects", key = "#pageable.pageNumber")
    public Page<ProjectDto> getProjects(Pageable pageable) {
       return projectRepository.findAll(pageable).map(projectMapper::toDto);
    }

    @Override
    @CachePut(value = "projects", key = "#id")
    public String updateProject(Long id, ProjectDto projectDto) {
        if(!projectRepository.existsById(id)) {
            throw new IllegalArgumentException("Project not found");
        }

        Project updatedProject = projectMapper.toEntity(projectDto);
        updatedProject.setId(id);

        projectRepository.save(updatedProject);

        tasksPerProjectRepository.refreshTasksMaterializedView();

        return "Project updated successfully";
    }

    @Override
    @CacheEvict(value = "projects", allEntries = true)
    public String deleteProject(Long id) {
        if(!projectRepository.existsById(id)) {
            throw new IllegalArgumentException("Project not found");
        }

        projectRepository.deleteById(id);

        tasksPerProjectRepository.refreshTasksMaterializedView();

        return "Project deleted successfully";
    }
}
