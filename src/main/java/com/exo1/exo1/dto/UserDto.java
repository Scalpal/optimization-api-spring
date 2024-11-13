package com.exo1.exo1.dto;

import com.exo1.exo1.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String name;

    private String email;

    private List<Project> projects;
}
