package com.example.springtutorial.controller;
import com.example.springtutorial.models.file_model;
import com.example.springtutorial.service.file_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "file")
public class file_controller {

    private file_service fileService;

    @PostMapping()
    public file_model uploadFile(@RequestParam("file")MultipartFile file) throws IOException {
        return fileService.store(file);
    }

    @GetMapping("/{id}")
    public file_model getFile(@PathVariable String id){
        return fileService.getFileById(id);
    }

    @GetMapping("/list")
    public List<file_model> getFileList(){
        return fileService.getFileList();
    }

}
