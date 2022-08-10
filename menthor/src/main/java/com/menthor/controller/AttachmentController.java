package com.menthor.controller;
/*
 Belongs to File Upload
 */
import com.menthor.model.Attachment;
import com.menthor.model.ResponseData;
import com.menthor.service.AttachmentService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@CrossOrigin(origins = "*")
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
                ZonedDateTime.now(ZoneId.of("Turkey")),
                "You have successfully uploaded the file."
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

    @GetMapping("/listfiles/{uploader_id}")
    public List<Attachment> listFile (@PathVariable ("uploader_id") String uploader_id){
        return attachmentService.getFiles(uploader_id);
    }

    @GetMapping("/getMatchId/{userId}")
    public Long GetMatchId(@PathVariable Long userId){
        return attachmentService.GetMatchId(userId);
    }
}
