package com.example.tasktracker.DTO;

import com.example.tasktracker.enums.TaskPriority;

public class TaskSummaryDto {
    private Long id;
    private String title;
    private TaskPriority priority;

    public TaskSummaryDto(Long id, String title, TaskPriority priority) {
        this.id = id;
        this.title = title;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

}