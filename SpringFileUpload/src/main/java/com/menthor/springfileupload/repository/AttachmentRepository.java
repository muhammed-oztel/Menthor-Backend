package com.menthor.springfileupload.repository;

import com.menthor.springfileupload.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, String> {

}
