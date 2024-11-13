package com.exo1.exo1.controller;

import com.exo1.exo1.dto.ProjectDto;
import com.exo1.exo1.entity.Project;
import com.exo1.exo1.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@AllArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<String> createProject(@RequestBody ProjectDto projectDto) {
        String response = projectService.createProject(projectDto);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<Project> getProject(@PathVariable Long projectId) {
        Project response = projectService.getProject(projectId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<String> updateProject(@PathVariable Long projectId, @RequestBody ProjectDto projectDto) {
        String response = projectService.updateProject(projectId, projectDto);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<String> deleteProject(@PathVariable Long projectId) {
        String response = projectService.deleteProject(projectId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
