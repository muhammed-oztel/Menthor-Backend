package com.fileupload.springfileuploadgradle.service;

import com.fileupload.springfileuploadgradle.entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AttachmentService {
    Attachment saveAttachment(MultipartFile file, String uploader_id) throws Exception;

    Attachment getAttachment(Long fileId) throws Exception;

    List<Attachment> getFiles(String uploader_id);
    void deleteFile(Long id);
}
