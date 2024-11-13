package com.exo1.exo1.service.impl;

import com.exo1.exo1.dto.ProjectDto;
import com.exo1.exo1.dto.TaskDto;
import com.exo1.exo1.entity.Project;
import com.exo1.exo1.entity.Task;
import com.exo1.exo1.entity.User;
import com.exo1.exo1.mapper.TaskMapper;
import com.exo1.exo1.repository.ProjectRepository;
import com.exo1.exo1.repository.TaskRepository;
import com.exo1.exo1.repository.TasksPerProjectRepository;
import com.exo1.exo1.repository.UserRepository;
import com.exo1.exo1.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TasksPerProjectRepository tasksPerProjectRepository;

    private final TaskMapper taskMapper;

    @Override
    public String createTask(TaskDto taskDto) {
        Task newTask = taskMapper.toEntity(taskDto);

        taskRepository.save(newTask);

        tasksPerProjectRepository.refreshTasksMaterializedView();

        return "Task successfully created";
    }

    @Override
    @Cacheable(value = "tasks", key = "#id")
    public TaskDto getTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task not found"));

        return taskMapper.toDto(task);
    }

    @Override
    @Cacheable(value = "tasks", key = "#pageable.pageNumber")
    public Page<TaskDto> getAllTasks(Pageable pageable) {
        return taskRepository.findAll(pageable).map(taskMapper::toDto);
    }

    @Override
    @CachePut(value = "tasks", key = "#id")
    public String updateTask(Long id, TaskDto taskDto) {
        if(!taskRepository.existsById(id)) {
            throw new IllegalArgumentException("Task does not exist");
        }

        Task newTask = taskMapper.toEntity(taskDto);
        newTask.setId(id);

        taskRepository.save(newTask);

        tasksPerProjectRepository.refreshTasksMaterializedView();

        return "Task successfully updated";
    }

    @Override
    @CacheEvict(value = "projects", allEntries = true)
    public String deleteTask(Long id) {
        if(!taskRepository.existsById(id)) {
            throw new IllegalArgumentException("Task does not exist");
        }

        taskRepository.deleteById(id);

        tasksPerProjectRepository.refreshTasksMaterializedView();

        return "Task successfully deleted";
    }
}
