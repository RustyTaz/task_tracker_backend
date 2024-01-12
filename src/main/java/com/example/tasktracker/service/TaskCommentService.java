package com.example.tasktracker.service;

import com.example.tasktracker.DTO.TaskCommentDto;
import com.example.tasktracker.entity.Task;
import com.example.tasktracker.entity.TaskComment;
import com.example.tasktracker.entity.User;
import com.example.tasktracker.repository.TaskCommentRepository;
import com.example.tasktracker.repository.TaskRepository;
import com.example.tasktracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskCommentService {

    @Autowired
    private TaskCommentRepository taskCommentRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public TaskCommentDto createTaskComment(TaskCommentDto taskCommentDto) {
        TaskComment taskComment = new TaskComment();
        taskComment.setText(taskCommentDto.getText());
        taskComment.setCreationDate(LocalDateTime.now());

        // Найти и установить задачу, к которой относится комментарий
        Task task = taskRepository.findById(taskCommentDto.getTaskId())
                .orElseThrow(() -> new RuntimeException("Task not found"));
        taskComment.setTask(task);

        // Найти и установить пользователя, оставившего комментарий
        User user = userRepository.findById(taskCommentDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        taskComment.setUser(user);

        // Сохранить комментарий
        TaskComment savedComment = taskCommentRepository.save(taskComment);

        return convertToDto(savedComment);
    }

    public TaskCommentDto updateTaskComment(Long id, TaskCommentDto taskCommentDto) {
        return taskCommentRepository.findById(id)
                .map(taskComment -> {
                    taskComment.setText(taskCommentDto.getText());
                    // Обновление других полей при необходимости
                    return convertToDto(taskCommentRepository.save(taskComment));
                }).orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    public void deleteTaskComment(Long id) {
        taskCommentRepository.deleteById(id);
    }

    public List<TaskCommentDto> getCommentsByTaskId(Long taskId) {
        return taskCommentRepository.findByTaskId(taskId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private TaskCommentDto convertToDto(TaskComment taskComment) {
        return new TaskCommentDto(
                taskComment.getId(),
                taskComment.getText(),
                taskComment.getTask() != null ? taskComment.getTask().getId() : null,
                taskComment.getUser() != null ? taskComment.getUser().getId() : null
        );
    }
}