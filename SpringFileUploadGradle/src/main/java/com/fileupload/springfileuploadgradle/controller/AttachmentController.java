package com.fileupload.springfileuploadgradle.controller;


import com.fileupload.springfileuploadgradle.entity.Attachment;
import com.fileupload.springfileuploadgradle.model.ResponseData;
import com.fileupload.springfileuploadgradle.service.AttachmentService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;

@RestController
public class AttachmentController {

    private AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }
    @PostMapping("/upload")
    public ResponseData uploadFile(@RequestParam("file")MultipartFile file,String uploader_id) throws Exception {
        Attachment attachment = null;
        String downloadURL = "";
        attachment = attachmentService.saveAttachment(file,uploader_id);
        downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path (attachment.getId().toString())
                //.path (attachment.getId())
                .toUriString();


        return new ResponseData(
                uploader_id,
                attachment.getFileName(),
                downloadURL,
                file.getContentType(),
                file.getSize(),
                LocalDate.now()
        );
    }

    @GetMapping("download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long fileId) throws Exception {
        Attachment attachment = null;
        attachment = attachmentService.getAttachment(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(attachment.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" +
                                attachment.getFileName() + "\"")
                .body(new ByteArrayResource(attachment.getData()));


    }

    @DeleteMapping("/delete/{id}")
    public String deleteFile(@PathVariable ("id") Long id){
        attachmentService.deleteFile(id);
        return "You successfully deleted the file.";
    }

}