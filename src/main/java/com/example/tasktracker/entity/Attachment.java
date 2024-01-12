package com.example.tasktracker.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "attachments")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String fileUrl;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    // Конструкторы, геттеры и сеттеры

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    // Метод для удобства получения идентификатора задачи
    public Long getTaskId() {
        return task != null ? task.getId() : null;
    }

    // Метод для удобства установки идентификатора задачи
    public void setTaskId(Long taskId) {
        if (this.task == null) {
            this.task = new Task();
        }
        this.task.setId(taskId);
    }

}

