package com.menthor.model;
/*
 Belongs to File Upload
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData {

    private String uploader_id;
    private String fileName;
    private String downloadURL;
    private String fileType;
    private long fileSize;
    private LocalDate localDate;
    private String message;


}