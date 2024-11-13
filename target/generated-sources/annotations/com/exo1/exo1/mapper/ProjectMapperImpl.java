package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.ProjectDto;
import com.exo1.exo1.dto.TaskDto;
import com.exo1.exo1.entity.Project;
import com.exo1.exo1.entity.Task;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-13T12:13:10+0100",
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
        projectDto.setTasks( taskListToTaskDtoList( project.getTasks() ) );

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
        project.setTasks( taskDtoListToTaskList( projectDto.getTasks() ) );

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

    @Override
    public List<Project> toEntities(List<ProjectDto> projectDtos) {
        if ( projectDtos == null ) {
            return null;
        }

        List<Project> list = new ArrayList<Project>( projectDtos.size() );
        for ( ProjectDto projectDto : projectDtos ) {
            list.add( toEntity( projectDto ) );
        }

        return list;
    }

    protected TaskDto taskToTaskDto(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskDto taskDto = new TaskDto();

        taskDto.setTitle( task.getTitle() );
        taskDto.setStatus( task.getStatus() );

        return taskDto;
    }

    protected List<TaskDto> taskListToTaskDtoList(List<Task> list) {
        if ( list == null ) {
            return null;
        }

        List<TaskDto> list1 = new ArrayList<TaskDto>( list.size() );
        for ( Task task : list ) {
            list1.add( taskToTaskDto( task ) );
        }

        return list1;
    }

    protected Task taskDtoToTask(TaskDto taskDto) {
        if ( taskDto == null ) {
            return null;
        }

        Task task = new Task();

        task.setTitle( taskDto.getTitle() );
        task.setStatus( taskDto.getStatus() );

        return task;
    }

    protected List<Task> taskDtoListToTaskList(List<TaskDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Task> list1 = new ArrayList<Task>( list.size() );
        for ( TaskDto taskDto : list ) {
            list1.add( taskDtoToTask( taskDto ) );
        }

        return list1;
    }
}
