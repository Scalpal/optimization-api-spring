package com.exo1.exo1.service.impl;

import com.exo1.exo1.dto.TaskDto;
import com.exo1.exo1.entity.Project;
import com.exo1.exo1.entity.Task;
import com.exo1.exo1.entity.User;
import com.exo1.exo1.mapper.TaskMapper;
import com.exo1.exo1.repository.ProjectRepository;
import com.exo1.exo1.repository.TaskRepository;
import com.exo1.exo1.repository.UserRepository;
import com.exo1.exo1.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    private final TaskMapper taskMapper;

    @Override
    public String createTask(TaskDto taskDto) {
        Task newTask = taskMapper.toEntity(taskDto);

        Project project = projectRepository.findById(taskDto.getProjectId()).orElseThrow(() -> new IllegalArgumentException("Project does not exist"));
        User user = userRepository.findById(taskDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("User does not exist"));

        newTask.setProject(project);
        newTask.setUser(user);

        taskRepository.save(newTask);

        return "Task successfully created";
    }

    @Override
    public Task getTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task not found"));

        return task;
    }

    @Override
    public String updateTask(Long id, TaskDto taskDto) {
        if(!taskRepository.existsById(id)) {
            throw new IllegalArgumentException("Task does not exist");
        }

        Task newTask = taskMapper.toEntity(taskDto);

        taskRepository.save(newTask);

        return "Task successfully updated";
    }

    @Override
    public String deleteTask(Long id) {
        if(!taskRepository.existsById(id)) {
            throw new IllegalArgumentException("Task does not exist");
        }

        taskRepository.deleteById(id);

        return "Task successfully deleted";
    }
}
