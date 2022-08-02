package com.fileupload.springfileuploadgradle.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data@NoArgsConstructor

public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   // @Generated Value (generator = "uuid" )
   // @GenericGenerator(name = "uuid", strategy = "uuid2")
    private Long id;
    //private String id;
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

}