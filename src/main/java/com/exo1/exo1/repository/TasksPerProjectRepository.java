package com.exo1.exo1.repository;

import com.exo1.exo1.entity.TasksPerProject;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TasksPerProjectRepository extends JpaRepository<TasksPerProject, Long> {
    @Transactional
    @Modifying
    @Query(value = "REFRESH MATERIALIZED VIEW tasks_per_project", nativeQuery = true)
    public void refreshTasksMaterializedView();
}