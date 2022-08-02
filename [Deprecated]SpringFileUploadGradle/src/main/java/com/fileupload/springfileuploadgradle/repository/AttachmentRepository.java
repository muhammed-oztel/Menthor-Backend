package com.fileupload.springfileuploadgradle.repository;

import com.fileupload.springfileuploadgradle.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, String> {

}