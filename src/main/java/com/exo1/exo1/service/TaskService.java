package com.exo1.exo1.service;

import com.exo1.exo1.dto.TaskDto;
import com.exo1.exo1.entity.Task;

public interface TaskService {
    String createTask(TaskDto taskDto);

    Task getTask(Long id);

    String updateTask(Long id, TaskDto taskDto);

    String deleteTask(Long id);
}
