package com.example.tasktracker.controllers;

import com.example.tasktracker.DTO.AttachmentDto;
import com.example.tasktracker.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attachments")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;

    @PostMapping
    public ResponseEntity<AttachmentDto> createAttachment(@RequestBody AttachmentDto attachmentDto) {
        return ResponseEntity.ok(attachmentService.createAttachment(attachmentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttachment(@PathVariable Long id) {
        attachmentService.deleteAttachment(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/by-task/{taskId}")
    public ResponseEntity<List<AttachmentDto>> getAttachmentsByTaskId(@PathVariable Long taskId) {
        return ResponseEntity.ok(attachmentService.getAttachmentsByTaskId(taskId));
    }
}
