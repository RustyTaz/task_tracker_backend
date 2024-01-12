package com.example.tasktracker.DTO;

public class TaskCommentDto {
    private Long id;
    private String text;
    private Long taskId;
    private Long userId; // ID пользователя

    // Конструкторы, геттеры и сеттеры
    public TaskCommentDto(Long id, String text, Long taskId, Long userId) {
        this.id = id;
        this.text = text;
        this.taskId = taskId;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}