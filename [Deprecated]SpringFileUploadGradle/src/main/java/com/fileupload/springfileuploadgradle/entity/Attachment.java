package com.fileupload.springfileuploadgradle.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.time.LocalDate;

@Entity
@Data@NoArgsConstructor

public class Attachment {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String uploader_id;
    private String fileName;
    private String fileType;
    @Lob
    private byte[] data;
    private LocalDate localDate;

    public Attachment(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

    public Attachment(String fileName, String fileType, byte[] data, LocalDate localDate) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        this.localDate = localDate;
    }

    public Attachment(String uploader_id, String fileName, String fileType, byte[] data, LocalDate localDate) {
        this.uploader_id = uploader_id;
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        this.localDate = localDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}