package com.fileupload.springfileuploadgradle.repository;

import com.fileupload.springfileuploadgradle.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {

    @Query("select u from Attachment u where u.uploader_id = ?1")
    List<Attachment> findbyUploaderId(String uploader_id);
}