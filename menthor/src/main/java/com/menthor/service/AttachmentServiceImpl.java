package com.menthor.service;
/*
 Belongs to File Upload
 */

import com.menthor.model.Attachment;
import com.menthor.model.UserEntity;
import com.menthor.repository.AttachmentRepository;
import com.menthor.repository.MatchRepository;
import com.menthor.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class AttachmentServiceImpl implements AttachmentService{

    private AttachmentRepository attachmentRepository;
    private final UserRepository userRepository;
    private final MatchRepository matchRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository, UserRepository userRepository, MatchRepository matchRepository) {
        this.attachmentRepository = attachmentRepository;
        this.userRepository = userRepository;
        this.matchRepository = matchRepository;
    }

    @Override
    public Attachment saveAttachment(MultipartFile file,String uploader_id) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try{
            if(fileName.contains("..")){
                throw new Exception("Filename contains invalid path sequence" + fileName);
            }
            Attachment attachment = new Attachment(uploader_id,fileName, file.getContentType(),file.getBytes(), ZonedDateTime.now(ZoneId.of("Turkey")).toString());
            return attachmentRepository.save(attachment);

        }catch(Exception e){
            throw new Exception("Could not save File " + fileName);
        }
    }

    @Override
    public Attachment getAttachment(Long fileId) throws Exception {
        return attachmentRepository.findById(fileId)
                .orElseThrow(() -> new Exception("File not found with Id: " + fileId));
    }

    @Override
    public void deleteFile(Long id) {
        boolean exists = attachmentRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("File with id" + id + "does not exist");
        }
        attachmentRepository.deleteById(id);

    }

    @Transactional
    @Override
    public List<Attachment> getFiles(String uploader_id){
        return attachmentRepository.findbyUploaderId(uploader_id);
    }

    public Long GetMatchId(Long userId){
        try {
            UserEntity user = userRepository.getReferenceById(userId);
            Long matchId = null;
            if (user.getRole().toLowerCase().equals("mentor")){
                matchId = matchRepository.findByMentorAndAndDeleted(userId, null).get(0).getId();
            }else if (user.getRole().toLowerCase().equals("mentee")){
                matchId = matchRepository.findByMenteeAndAndDeleted(userId, null).get(0).getId();
            }
            return matchId;
        }catch (Exception ex){
            return null;
        }
    }
}