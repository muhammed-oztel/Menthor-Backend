package com.menthor.repository;
/*
 Belongs to File Upload
 */
import com.menthor.model.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {

    @Query("select u from Attachment u where u.uploader_id = ?1 order by u.zonedDateTime desc")
    List<Attachment> findbyUploaderId(String uploader_id);

}