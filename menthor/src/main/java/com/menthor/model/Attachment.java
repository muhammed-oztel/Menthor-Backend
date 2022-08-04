package com.menthor.model;
/*
 Belongs to File Upload
 */
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private LocalDateTime localDateTime;

    public Attachment(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

    public Attachment(String fileName, String fileType, byte[] data, LocalDateTime localDateTime) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        this.localDateTime = localDateTime;
    }

    public Attachment(String uploader_id, String fileName, String fileType, byte[] data, LocalDateTime localDateTime) {
        this.uploader_id = uploader_id;
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        this.localDateTime = localDateTime;
    }

}