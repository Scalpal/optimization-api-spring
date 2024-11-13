package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.ProjectDto;
import com.exo1.exo1.entity.Project;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectDto toDto (Project project);

    Project toEntity (ProjectDto projectDto);

    List<ProjectDto> toDtos (List<Project> projects);
}
