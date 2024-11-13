package com.exo1.exo1.service;

import com.exo1.exo1.dto.TaskDto;
import com.exo1.exo1.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {
    TaskDto getTask(Long id);

    Page<TaskDto> getAllTasks(Pageable pageable);

    String createTask(TaskDto taskDto);

    String updateTask(Long id, TaskDto taskDto);

    String deleteTask(Long id);
}
