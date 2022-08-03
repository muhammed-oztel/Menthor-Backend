package com.fileupload.springfileuploadgradle.service;

import com.fileupload.springfileuploadgradle.entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {
    Attachment saveAttachment(MultipartFile file, String uploader_id) throws Exception;

    Attachment getAttachment(Long fileId) throws Exception;

    void deleteFile(Long id);
}