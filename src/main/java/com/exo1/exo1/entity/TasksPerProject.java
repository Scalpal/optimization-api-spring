package com.exo1.exo1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "tasks_per_project")
@Immutable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TasksPerProject {
    @Id
    private Long projectId;

    @Column(name = "tasks_count")
    private Long tasksCount;
}
