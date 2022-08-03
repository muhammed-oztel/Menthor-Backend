package com.fileupload.springfileuploadgradle.service;

import com.fileupload.springfileuploadgradle.entity.Attachment;
import com.fileupload.springfileuploadgradle.repository.AttachmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Service
public class AttachmentServiceImpl implements AttachmentService{

    private AttachmentRepository attachmentRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public Attachment saveAttachment(MultipartFile file,String uploader_id) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try{
            if(fileName.contains("..")){
                throw new Exception("Filename contains invalid path sequence" + fileName);
            }
            Attachment attachment = new Attachment(uploader_id,fileName, file.getContentType(),file.getBytes(), LocalDate.now());
            return attachmentRepository.save(attachment);

        }catch(Exception e){
            throw new Exception("Could not save File" + fileName);
        }
    }

    @Override
    public Attachment getAttachment(String fileId) throws Exception {
        return attachmentRepository.findById(fileId)
                .orElseThrow(() -> new Exception("File not found with Id: " + fileId));
    }

    @Override
    public void deleteFile(String id) {
        boolean exists = attachmentRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("File with id" + id + "does not exist");
        }
        attachmentRepository.deleteById(id);

    }
}