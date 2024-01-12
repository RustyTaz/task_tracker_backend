package com.example.tasktracker.repository;

import com.example.tasktracker.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByTitle(String title);
    List<Task> findByTeam_Id(Long teamId);
   // List<Task> findByTeamId(Long teamId);
}