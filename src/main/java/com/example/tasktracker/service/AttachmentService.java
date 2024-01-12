package com.example.tasktracker.service;

import com.example.tasktracker.DTO.AttachmentDto;
import com.example.tasktracker.entity.Attachment;
import com.example.tasktracker.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttachmentService {

    @Autowired
    private AttachmentRepository attachmentRepository;

    public AttachmentDto createAttachment(AttachmentDto attachmentDto) {
        Attachment attachment = new Attachment();
        attachment.setFileName(attachmentDto.getFileName());
        attachment.setFileUrl(attachmentDto.getFileUrl());
        attachment.setTaskId(attachmentDto.getTaskId());

        return convertToDto(attachmentRepository.save(attachment));
    }

    public void deleteAttachment(Long id) {
        attachmentRepository.deleteById(id);
    }

    public List<AttachmentDto> getAttachmentsByTaskId(Long taskId) {
        return attachmentRepository.findByTaskId(taskId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private AttachmentDto convertToDto(Attachment attachment) {
        AttachmentDto attachmentDto = new AttachmentDto();
        attachmentDto.setId(attachment.getId());
        attachmentDto.setFileName(attachment.getFileName());
        attachmentDto.setFileUrl(attachment.getFileUrl());
        attachmentDto.setTaskId(attachment.getTaskId());
        return attachmentDto;
    }
}
