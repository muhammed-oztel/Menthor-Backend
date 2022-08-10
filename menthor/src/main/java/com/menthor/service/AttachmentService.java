package com.menthor.service;
/*
 Belongs to File Upload
 */

import com.menthor.model.Attachment;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AttachmentService {
    Attachment saveAttachment(MultipartFile file, String uploader_id) throws Exception;

    Attachment getAttachment(Long fileId) throws Exception;

    List<Attachment> getFiles(String uploader_id);

    void deleteFile(Long id);

    Long GetMatchId(Long userId);
}