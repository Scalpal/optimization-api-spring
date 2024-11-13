package com.exo1.exo1.dto;

import com.exo1.exo1.entity.Task;
import com.exo1.exo1.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {
    private String name;

    private String description;

    private List<TaskDto> tasks;
}
