package com.example.springtutorial.service;
import com.example.springtutorial.models.file_model;
import com.example.springtutorial.repository.file_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class file_service {

    @Autowired
    private file_repository fileRepository;

    public file_model store(MultipartFile file) throws IOException {
        String fileName= file.getOriginalFilename();
        file_model fileModel = new file_model(UUID.randomUUID().toString(), fileName, file.getContentType(), file.getBytes());
        return fileRepository.save(fileModel) ;
    }

    public file_model getFileById(String id){
        Optional<file_model> fileOptional = fileRepository.findById(id);

        if(fileOptional.isPresent()){
            return fileOptional.get();
        }
        return null;
    }

    public List<file_model> getFileList(){
        return  fileRepository.findAll();
    }

}
