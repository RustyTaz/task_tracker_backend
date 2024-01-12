package com.example.tasktracker.controllers;

import com.example.tasktracker.DTO.TaskCommentDto;
import com.example.tasktracker.service.TaskCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-comments")
public class TaskCommentController {

    @Autowired
    private TaskCommentService taskCommentService;

    @PostMapping
    public ResponseEntity<TaskCommentDto> createTaskComment(@RequestBody TaskCommentDto taskCommentDto) {
        return ResponseEntity.ok(taskCommentService.createTaskComment(taskCommentDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskCommentDto> updateTaskComment(@PathVariable Long id, @RequestBody TaskCommentDto taskCommentDto) {
        return ResponseEntity.ok(taskCommentService.updateTaskComment(id, taskCommentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskComment(@PathVariable Long id) {
        taskCommentService.deleteTaskComment(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/by-task/{taskId}")
    public ResponseEntity<List<TaskCommentDto>> getCommentsByTaskId(@PathVariable Long taskId) {
        return ResponseEntity.ok(taskCommentService.getCommentsByTaskId(taskId));
    }
}
