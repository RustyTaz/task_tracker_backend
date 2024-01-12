package com.example.tasktracker.repository;

import com.example.tasktracker.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
    @Query("SELECT a FROM Attachment a WHERE a.task.id = :taskId")
    List<Attachment> findByTaskId(Long taskId);
    //List<Attachment> findByTask_Id(Long taskId);
}
