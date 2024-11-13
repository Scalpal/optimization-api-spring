package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.ProjectDto;
import com.exo1.exo1.entity.Project;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-12T16:19:11+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Amazon.com Inc.)"
)
@Component
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public ProjectDto toDto(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDto projectDto = new ProjectDto();

        projectDto.setName( project.getName() );
        projectDto.setDescription( project.getDescription() );

        return projectDto;
    }

    @Override
    public Project toEntity(ProjectDto projectDto) {
        if ( projectDto == null ) {
            return null;
        }

        Project project = new Project();

        project.setName( projectDto.getName() );
        project.setDescription( projectDto.getDescription() );

        return project;
    }

    @Override
    public List<ProjectDto> toDtos(List<Project> projects) {
        if ( projects == null ) {
            return null;
        }

        List<ProjectDto> list = new ArrayList<ProjectDto>( projects.size() );
        for ( Project project : projects ) {
            list.add( toDto( project ) );
        }

        return list;
    }
}
