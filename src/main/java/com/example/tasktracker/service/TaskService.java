package com.example.tasktracker.service;

import com.example.tasktracker.DTO.TaskDto;
import com.example.tasktracker.DTO.TaskSummaryDto;
import com.example.tasktracker.entity.Task;
import com.example.tasktracker.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<TaskDto> getTaskById(Long id) {
        return taskRepository.findById(id).map(this::convertToDto);
    }

    public Optional<TaskDto> getTaskByTitle(String title) {
        return taskRepository.findByTitle(title).map(this::convertToDto);
    }

    public List<TaskSummaryDto> getTasksByTeamId(Long teamId) {
        return taskRepository.findByTeam_Id(teamId).stream()
                .map(task -> new TaskSummaryDto(task.getId(), task.getTitle(), task.getPriority()))
                .collect(Collectors.toList());
    }

    public TaskDto createTask(TaskDto taskDto) {
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setCreationDate(LocalDateTime.now()); // или установить из DTO, если необходимо
        task.setStatus(taskDto.getStatus());
        task.setPriority(taskDto.getPriority());
        task.setCreatedByUserId(taskDto.getCreatedByUserId());
        task.setResponsibleUserId(taskDto.getResponsibleUserId());
        task.setDeadline(taskDto.getDeadline());
        task.setTeamId(taskDto.getTeamId());

        return convertToDto(taskRepository.save(task));
    }


    public Optional<TaskDto> updateTask(Long id, TaskDto taskDto) {
        return taskRepository.findById(id).map(task -> {
            task.setTitle(taskDto.getTitle());
            task.setDescription(taskDto.getDescription());
            task.setStatus(taskDto.getStatus());
            task.setPriority(taskDto.getPriority());
            task.setCreatedByUserId(taskDto.getCreatedByUserId());
            task.setResponsibleUserId(taskDto.getResponsibleUserId());
            task.setDeadline(taskDto.getDeadline());
            task.setTeamId(taskDto.getTeamId());

            return convertToDto(taskRepository.save(task));
        });
    }


    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    private TaskDto convertToDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setTitle(task.getTitle());
        taskDto.setDescription(task.getDescription());
        taskDto.setCreationDate(task.getCreationDate());
        taskDto.setStatus(task.getStatus());
        taskDto.setPriority(task.getPriority());
        taskDto.setCreatedByUserId(task.getCreatedByUserId());
        taskDto.setResponsibleUserId(task.getResponsibleUserId());
        taskDto.setDeadline(task.getDeadline());
        taskDto.setTeamId(task.getTeamId());

        return taskDto;
    }

}